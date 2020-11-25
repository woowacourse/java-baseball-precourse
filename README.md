# 미션 - 숫자 야구 게임

## 🚀 기능 요구사항
- 이 게임은 프로그램이 1에서 9까지 서로 다른 임의의 수 3개를 정하고 이를 플레이어가 맞추는 게임이다.
- 정답을 맞추기 위해 3자리수를 입력하고 힌트를 받는다.
- 힌트는 야구용어인 볼과 스트라이크로 받는데, 같은 자리에 같은 숫자가 있는 경우를 `스트라이크`, 다른 자리에 숫자가 있는 경우를 `볼`로 정한다.
- 같은 숫자가 하나도 없는 경우 힌트로 `낫싱`을 받는다.
  - 예시) 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우: 1스트라이크, 456을 제시한 경우: 1볼 1스트라이크, 789를 제시한 경우: 낫싱
- 3자리 숫자가 정답과 같은 경우 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.

<br>

## ✍🏻 입출력 요구사항
### ⌨️ 입력
- 3자리의 수
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

### 🖥 출력
- 입력한 수에 대한 결과를 볼, 스트라이크 갯수로 표시
```
1볼 1스트라이크
```
- 하나도 없는 경우 
```
낫싱
```
- 3개의 숫자를 모두 맞힐 경우
```
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```

### 💻 프로그래밍 실행 결과 예시
```
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼 1스트라이크
… 
```

<br>

## 🎱 프로그래밍 요구사항
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- System.exit 메소드를 사용하지 않는다.
- 비정상적 입력에 대해서는 IllegalArgumentException을 발생시킨다.

### 프로그래밍 요구사항 - Application
- Application 클래스를 활용해 구현해야 한다.
- Application의 패키지 구조와 구현은 변경하지 않는다.
- `final Scanner scanner = new Scanner(System.in);`는 변경하지 않는다.
- `// TODO 구현 진행` 이 후 부터 구현한다.

```java
public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
    }
}
```

### 프로그래밍 요구사항 - RandomUtils
- RandomUtils 클래스를 활용해 랜덤 기능을 구현해야 한다.
- RandomUtils의 패키지 구조와 구현은 변경하지 않는다.

```java
private static final Random RANDOM = new Random();
    private RandomUtils() {
    }
    public static int nextInt(final int startInclusive, final int endInclusive) {
    ...
```

<br>

## 📈 진행 요구사항
- 미션은 [java-baseball-precourse 저장소](https://github.com/woowacourse/java-baseball-precourse) 를 fork/clone해 시작한다.
- 기능을 구현하기 전에 java-baseball-precourse/README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
  - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.
- [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 절차를 따라 미션을 제출한다.

<br>

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.

<br>

# Document v0.1
|작성자|작성일자|작성내용|버전|
|------|--------|------|---|
|허재혁|2020.11.25|최초 작성|0.1|

## 요구조건 파악
### 주어진 요건
#### RandomUtils
```
RandomUtils.nextInt(int startInclusive, int endInclusive);
```
- 역할
    - 위 static 메소드는 startInclusive와 endInclusive 사이의 수(들)에서 하나의 수를 랜덤하게 뽑는다.
- 책임
    - startInclusive와 endInclusive의 대소를 비교하고 startInclusive <= endInclusive의 경우에만 랜덤하게 수를 뽑는다. 나머지 경우에는 IllegalArgumentException이 발생한다.
- 관계
    - 문제에 따르면 서로 다른 임의의 수를 뽑아야 하므로 위 메소드로 뽑은 수가 그 전에 뽑은 수에 포함되었는지 검증한 후 없는 경우에만 포함시킨다. 따라서 이를 검증할 객체/메소를 구현해야 한다.

<br>

### 구현해야 할 객체

<br>

#### class InputHandler
- 역할
    - 플레이어의 입력값을 받는다.
- 책임
    - [ ] '숫자를 입력해주세요 : '라는 명령과 함께 플레이어의 3자리 수를 입력받는다.
    - [ ] '게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n'라는 명령과 함께 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수를 입력받는다.
- 관계
    - 위 객체가 받은 책임 1)의 다음과 같은 예외를 처리할 객체(InputUtils)와 상호작용한다.
        - [ ] 3자리를 입력하지 않았을 경우
        - [ ] 3자리를 입력하였으나 공백이 포함된 경우
        - [ ] 3자리를 공백없이 입력하였으나 3자리 모두 숫자가 아닌 경우
        - 위의 예외들을 간단히 '3자리'의 '숫자'를 포함하지 않은 경우로 정리할 수 있다.
    - 위 객체가 받은 책임 2)의 다음과 같은 예외를 처리할 객체(InputUtils)와 상호작용한다.
        - [ ] 1과 2 이외의 값을 입력할 경우

<br>

#### class InputUtils
- 역할
    - 객체 InputHandler에서 입력받은 입력값의 예외를 처리한다.
- 책임
    - [ ] 플레이어의 입력값이 '3자리'의 '숫자'에 해당하는 지 판별한다.
    - [ ] 게임이 끝난 경우 재시작/종료를 명령하는 플레이어의 입력값이 1과 2에 해당하는 지 판별한다.
- 관계
    - [ ] 3자리의 숫자를 List의 형태로 InputHandler에 넘겨준다.
    - [ ] 재진행 여부를 논리값으로 InputHandler에 넘겨준다.

<br>

#### class OutputHandler
- 역할
    - 게임의 결과를 출력한다.
- 책임
    - [ ] 입력한 수에 대한 볼, 스트라이크 갯수와 낫싱을 출력한다.
    - [ ] 게임 종료 조건(3스트라이크)이 충족될 경우 '3개의 숫자를 모두 맞히셨습니다! 게임 종료'를 출력한다.
- 관계
    - [ ] 게임의 결과를 판별할 객체(Result)로부터 결과값(볼, 스트라이크 카운트 or 낫싱)을 받아온다.

<br>

#### class Result
- 역할
    - 게임의 결과를 판별한다.
- 책임
    - [ ] 스트라이크를 카운트한다.
    - [ ] 볼을 카운트한다.
    - [ ] 낫싱 여부를 판별한다.
- 관계
    - [ ] 게임의 결과값을 OutputHandler에 넘겨준다.

<br>

#### interface Participant
- 역할
    - 숫자 야구 게임 참가자에 공통된 메소드를 강제한다.
- 책임
    - [ ] 게임의 참가자인 Player와 Program에 3자리의 숫자를 List의 형태로 저장하는 것을 강제한다.
- 관계
    - [ ] Player에 implement한다.
    - [ ] Program에 implement한다.

<br>

#### class Player
- 역할
    - 플레이어의 입력값을 상태로 저장한다.
- 책임
    - [ ] 플레이어의 입력값을 List의 형태의 상태를 저장한다.
- 관계
    - [ ] 플레이어의 입력값을 Result에 넘겨준다.

<br>

#### class Program
- 역할
    - 무작위로 선별된 임의의 서로 다른 세자리 숫자를 저장한다.
- 책임
    - [ ] 임의의 서로 다른 3숫자를 받아 List의 형태로 저장한다.
- 관계
    - [ ] RandomUtils로부터 임의의 숫자를 받는다. 
    - [ ] 임의의 서로 다른 3숫자를 Result에 넘겨준다.