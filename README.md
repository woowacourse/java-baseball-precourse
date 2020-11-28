# 미션 - 숫자 야구 게임

## ✅ 구현할 기능 목록
- [x] 정답 생성 기능
  - [RandomUtils](#프로그래밍-요구사항---randomutils)를 이용하여 1~9사이의 수를 3개 생성한다.
  - 랜덤한 수를 생성할 때, 앞에서 이미 사용된 수라면 다시 생성한다.
- [x] 게임 인터페이스 기능
  - [Application](#프로그래밍-요구사항---application)의 메인 함수에서 출력을 직접 관리한다.
  - 입력이 있을 때, [예외처리](#-프로그래밍-요구사항)를 해줘야된다.
    - 숫자가 아닌 입력
    - 3자리가 아닌 입력
    - 숫자에 0이 있는 입력
    - 같은 숫자가 포함된 입력
- [x] 입력 받은 숫자가 정답인지 확인하는 기능
  - 입력받은 숫자를 [기능 요구사항](#-기능-요구사항)에 맞춰, 볼과 스트라이크를 구한 후 출력한다.
- [x] 게임 다시 시작 기능
  - 한 라운드가 종료되면 게임을 새로 시작할 것인지 묻고 실행해주는 기능을 구현한다.
  - 만약 1또는 2가 아닌 다른 값을 입력하면 예외처리를 한다.

<br>

## 🛠설계
게임에 필요한 정답과 기능들을 `GameManager` Class에 구현하고, `Application`은 `GameManager`을 이용하여 게임 상황을 파악하고 거기에 맞는 입출력을 처리한다.
### Application(Class)
- 루프를 계속 돌며, 사용자에게 정답을 요청한다.
  - 정답이 틀린 경우: 스트라이크와 볼을 출력하고 계속 루프를 돈다.
  - 정답이 맞는 경우: 사용자에게 개임을 새로 시작할 것인지 물어보고 입력을 요청한다.
    - 재시작(1): `GameManager`의 정답을 새로 생성하고 계속 루프를 돈다.
    - 종료(2): 루프에서 빠져나와, 프로그램을 종료시킨다.
### GameManager(Class)
- 변수
  - `NUMBER_ANSWER`: 게임에서 사용할 숫자의 개수. 요구사항에 맞춰 3으로 초기화한다.
  - `answer`: 게임의 정답. `Integer`의 `ArrayList`로 관리한다.
- 인스턴스 Enumeration
  - `GameStatus`: 현재 게임의 상태를 `enum`으로 관리한다. 새로 시작 요청시, 각 입력에 해당하는 숫자를 값으로 가진다.
    - `ONGOING`: 게임이 진행중인 상태.
    - `RESTART`: 사용자가 새로 시작을 요청한 상태.
    - `END`: 사용자가 종료를 요청한 상태.
- 생성자
  - `GameManager`: 랜덤한 정답을 생성한다. (`generateAnswer` 호출)
- 메소드
  - `generateAnswer`: `NUMBER_ANSWER`개수만큼의 1~9의 랜덤한 숫자를 `answer`에 저장한다. 숫자를 하나씩 생성할 때마다 중복되는 값이 있는지 매번 확인한다.(`findIndexOfList` 호출)
  - `checkAnswer`: 유저가 제시한 답이 정답인지 확인한다.(`findIndexOfList` 호출) 확인 후, 스트라이크와 볼의 개수를 출력한다.(`printScore` 호출) 정답이면 `true`, 오답이면 `false`를 반환한다.
  - `findIndexOfList`: 입력받은 `list`에서 입력받은 숫자가 존재하는지 확인하고 있다면 해당하는 `index`를 반환합니다. 없다면 `-1`을 반환한다.
  - `printScore`: 입력받은 `strike`와 `ball`을 통해, 스트라이크와 볼의 개수를 출력한다.
  - `requestInput`: 사용자에게 숫자를 입력받고, 숫자를 입력하지 않았을 경우 `IllegalArgumentException`을 발생시킨다.
  - `requestReplay`: 사용자에게 게임을 새로 시작하는지 입력을 받고(`requestInput` 호출), 1또는 2를 입력하지 않았다면 `IllegalArgumentException`을 발생시킨다.
  - `requestAnswer`: 사용자에게 숫자를 입력받고(`requestInput` 호출), 정답으로 나올 수 없는 입력일 경우 `IllegalArgumentException`을 발생시킨다.
  - `getAnswer`: `answer`를 `String` 자료형으로 반환한다. 디버깅용 메소드다.
### NotImplemnted(Annotation)
- 구현하지 못한 메소드를 표기하기 위해 사용한다.

<br>

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