# 전역 변수

```java
private static final Duration SIMPLE_TEST_TIMEOUT = Duration.ofSeconds(1L);
private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L);
```

- Duration.ofSeconds(): 시간(초)을 세팅하는 메소드
- SIMPLE_TEST_TIMEOUT: simple test의 타임아웃 시간 (1초)
- RANDOM_TEST_TIMEOUT: random test의 타임아웃 시간 (10초)

### Duration
> [Oracle docs](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html)  
- 초 / 나노초 단위의 시간 표현
- 분, 시간, 일 같은 다른 단위도 ok

<br>

# 메소드

### assertRandomNumberInRangeTest()
> 다른 메소드들은 파라미터의 차이가 있을 뿐 assertRandomTest() 메소드를 호출하게 되니 생략하였다.

```java
@Test
void 게임종료_후_재시작() {
    assertRandomNumberInRangeTest(
            () -> {
                run("246", "135", "1", "597", "589", "2");
                assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
            },
            1, 3, 5, 5, 8, 9
    );
}
```

먼저 동작 순서를 알기 쉽게 주어진 테스트 코드를 먼저 분석해보았다.  
run 안에 존재하는 파라미터들은 사용자가 입력하는 값이다.  
output()은 콘솔에 찍히는 로그를 의미하며 "낫싱", "3스트라이크", ... 등의 키워드가 포함된다면 true가 뜰 것이다.  
1, 3, 5, 5, 8, 9는 컴퓨터가 뽑은 랜덤 숫자이다.  

**동작 과정**  
첫번째 게임
- 컴퓨터: 135
- 사용자: 246 입력 -> 낫싱
- 사용자: 135 입력 -> 3스트라이크 -> 게임 종료
- 사용자: 1 입력 -> 게임 재시작

두번째 게임
- 컴퓨터: 589
- 사용자: 597 입력 -> 1볼 1스트라이크
- 사용자: 598 입력 -> 3스트라이크
- 사용자: 2 입력 -> 게임 종료

```java
public static void assertRandomNumberInRangeTest(
	final Executable executable,
	final Integer value,
	final Integer... values
) {
	assertRandomTest(
		() -> Randoms.pickNumberInRange(anyInt(), anyInt()),
			executable,
			value,
			values
	);
}
```

- [Executable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Executable.html): Method와 Constructor의 공통 기능을 공유하기 위한 super class 
- `...`를 이용해 Integer형 파라미터를 여러개 받기
- anyInt(): 입력되는 인자와 무관한 특정 값을 리턴하고 싶을 때 사용
- assertRandomTest() 호출


```java
private static <T> void assertRandomTest(
	final Verification verification,
	final Executable executable,
	final T value,
	final T... values
) {
	assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
		try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
			mock.when(verification).thenReturn(value, Arrays.stream(values).toArray());
			executable.execute();
		}
	});
}
```

- RANDOM_TEST_TIMEOUT초 내에 완료되지 않으면 타임아웃 에러
- [MockedStatic](https://javadoc.io/static/org.mockito/mockito-core/3.4.3/org/mockito/MockedStatic.html): static 함수를 가짜로 사용하기 위한 Mock에서 제공하는 기능
- when([Verification](https://www.javadoc.io/static/org.mockito/mockito-core/2.8.47/org/mockito/verification/package-summary.html))이 사용된다면 thenReturn(파라미터로 넣었던 value들)
- [assertTimeoutPreemptively](https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html): executable이 주어진 시간 안에 실행이 완료되는지 확인

<br>

### assertSimpleTest()

```java
public static void assertSimpleTest(final Executable executable) {
	assertTimeoutPreemptively(SIMPLE_TEST_TIMEOUT, executable);
}
```

- [assertTimeoutPreemptively](https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html): executable이 주어진 시간 안에 실행이 완료되는지 확인

<br>

# 버그 픽스
Application.java를 직접 실행할 때는 괜찮지만 ApplicationTest.java를 실행하는 경우 정상적으로 종료되지 않고 main 메소드가 여러번 호출되는 상황이 발생했다.  
테스트 코드에 문제가 포함되는지 확인하기 위해 Assertions 클래스를 분석해보았으나 해당 클래스는 원인이 아닌 것 같다.  
-> 원인을 발견했다. `게임종료_후_재시작()`와 `예외_테스트()` 두 개의 테스트 코드가 돌아가기 때문에 발생한 현상으로, 오류가 아니었다.

# 셀프 과제
MockedStatic이라는 클래스를 처음 봐서 해당 로직을 이해하는데 오래 걸렸다.
static 메소드와 아닌 메소드의 테스트 방법 차이에 대해 이해하고 Mockito가 무엇인지 공부해야겠다.