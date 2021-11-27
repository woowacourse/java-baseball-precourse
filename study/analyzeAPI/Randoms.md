# 전역 변수

```java
private static final Random defaultRandom = ThreadLocalRandom.current();
```

### ThreadLocalRandom
- 현재 스레드에 격리된 난수 생성기 (=스레드 별로 난수를 생성할 수 있음)
- current() 메소드를 통해 현재 스레드의 ThreadLocalRandom를 반환
- 참고 문서 - [docs.oracle.com](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadLocalRandom.html)

# 메소드

### pickNumberInList(List<Integer> numbers)

```java
public static int pickNumberInList(final List<Integer> numbers) {
    validateNumbers(numbers);
    return numbers.get(pickNumberInRange(0, numbers.size() - 1));
}
```

- validateNumbers()를 통해 List가 비어있지 않은지 검증
- return 파라미터로 주어지는 List 내의 랜덤한 숫자

<br>

### pickNumberInRange(int startInclusive, int endInclusive)

```java
public static int pickNumberInRange(final int startInclusive, final int endInclusive) {
    validateRange(startInclusive, endInclusive);
    return startInclusive + defaultRandom.nextInt(endInclusive - startInclusive + 1);
}
```

- validateRange()를 통해 startInclusive, endInclusive가 사용 가능한 범위인지 검증
- return startInclusive 부터 endInclusive 사이의 랜덤한 숫자  

<br>

### pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count)

```java
public static List<Integer> pickUniqueNumbersInRange(
    final int startInclusive,
    final int endInclusive,
    final int count
) {
    validateRange(startInclusive, endInclusive);
    validateCount(startInclusive, endInclusive, count);
    final List<Integer> numbers = new ArrayList<>();
    for (int i = startInclusive; i <= endInclusive; i++) {
        numbers.add(i);
    }
    return shuffle(numbers).subList(0, count);
}
```

- validateRange()를 통해 startInclusive, endInclusive가 사용 가능한 범위인지 검증
- validateCount()를 통해 유효한 count 값인지 검증
- startInclusive 부터 endInclusive 사이의 모든 숫자를 List에 추가
- shuffle()을 통해 List에 저장된 값을 섞기
- subList()를 통해 List의 인덱스 0부터 count까지 반환

<br>

# 생각
요 API 덕분에 더 편하게 코딩할 수 있었다. (없었다면 RandomUtils 같은 파일을 별도로 생성해야하지 않았을까?)  
과제에서는 pickNumberInRange() 메소드를 이용하라고 명시되어 있지만 pickUniqueNumbersInRange() 메소드를 이용하면 더 간편할 것 같은데 아쉽다.  
위 메소드를 이용해 내 방식대로 pickUniqueNumbersInRange() 메소드를 만들어도 재밌을 것 같다.