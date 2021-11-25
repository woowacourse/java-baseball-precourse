# 미션 - 숫자 야구 게임

## 🚀 기능 목록
1. 랜덤으로 1~9짜리 3개의 수를 생성한다.
2. 사용자에게 수를 입력받는다.
3. 입력받은 수를 검증한다.
4. 입력받은 3자리 수에서 볼, 스트라이크 개수를 구해서 반환한다.
5. 구해진 볼, 스트라이크를 통해 출력값을 결정한다.
  - 스트라이크 0개 : "낫싱"
  - 스트라이크 1개 ~ 2개 : "n볼 n스트라이크"
  - 스트라이크 3개 : "3스트라이크"
    - 정답문구 출력 : "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    - 계속 진행할 것인지 묻기 : "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
      - 1 입력 : 처음으로 돌아간다.
      - 2 입력 : 프로그램을 종료한다. 
6. 스트라이크 3개가 나올 때 까지 2~5과정을 반복한다.

## 커밋메세지 컨벤션
- "태그: 제목"의 형태이며, 태그는 영어로 쓰되 첫 문자는 대문자로 합니다.
- : 뒤에만 space가 있습니다.
- ex) feat(...): add score compute

|태그이름|설명|
|------|---|
|feat|새로운 기능을 추가할 경우|
|fix|버그를 고친 경우|
|style|코드 포맷 변경, 세미 콜론 누락, 코드 수정이 없는 경우
|refactor|프로덕션 코드 리팩토링
|comment|필요한 주석 추가 및 변경|
|docs|문서를 수정한 경우|
|test|테스트 추가, 테스트 리팩토링(프로덕션 코드 변경 X)
|chore|빌드 테스트 업데이트, 패키지 매니저를 설정하는 경우(프로덕션 코드 변경 X)
|rename|파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우
|remove|파일을 삭제하는 작업만 수행한 경우|

## Java 컨벤션 자주쓰거나 주의할 사항
### 접근제한자
클래스 및 멤버 수정자가 있는 경우 Java 언어 사양에서 권장하는 순서로 나타냄
```java
public protected private abstract default static final transient volatile synchronized native strictfp
```

### 예외 잡기: 생략하지 않음

아래 명시되있는 것말고 예외를 잡고 아무것도 안하는 것은 거의 있을 수 없습니다. (전형적인 반응은 로그를 남기는 것 혹은 불가능하다고 간주되면 AssertionError로 다시 던져줍니다.)
캐치 블록에서 아무것도 하지 않는 것이 정당하다면 주석을 남기는 것으로 정당화합니다.

```java
try {
    int i = Integer.parseInt(response);
    return handleNumericResponse(i);
} catch (NumberFormatException ok) {
    // it's not numeric; that's fine, just continue
}
return handleTextResponse(response);
```

예외: 테스트에서 예외를 잡는 부분은 expected, 혹은 expected로 시작하는 이름을 지으면서 무시할 수 있습니다. 다음 예제는 테스트에서 예외가 나오는게 확실한 상황에서 사용되는 대중적인 형식으로 주석이 필요없습니다.

```java
try {
    emptyStack.pop();
    fail();
} catch (NoSuchElementException expected) {
}
```
