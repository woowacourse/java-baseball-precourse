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

## 📝 구현할 기능 목록

### 게임(Game)
투구들(Pitchings), 판정기(Judge), 판정 기록기(JudgeReport)를 가지고 있다.
- 게임 시작(초기 생성) 시 랜덤한 투구들(Pitchings)과 모든 판정 규칙(JudgeRule)을 적용한 판정기(Judge), 그리고 비어있는 판정 기록기(JudgeReport)를 가진다.

### 투구(Pitching)
1개의 숫자를 의미한다.
- 1에서 9까지의 값을 가질 수 있다.

### 투구들(Pitchings)
3개의 숫자를 의미한다.
- 서로 중복되지 않는 투구(Pitching)를 3개 가지고 있다.
- 같은 위치에 있는 투구(Pitching)의 일치 여부를 확인한다.
- 특정 투구(Pitching)의 포함 여부를 확인한다.

### 판정기(Judge)
2개의 투구들(Pitchings)을 비교하여 판정(Judgment)을 내린다. 
- 비교 대상인 두 개의 투구(Pitching)가 위치와 숫자가 모두 같으면 스트라이크로 판정(Judgment)한다.
- 비교 대상인 두 개의 투구(Pitching)가 위치는 다르고 숫자만 같으면 볼로 판정(Judgment)한다.
- 비교 대상인 두 개의 투구(Pitching)가 위치와 숫자가 모두 다르면 낫싱으로 판정(Judgment)한다.
- 특정 투구(Pitching)에 대한 판정은 1개여야만 한다.

### 판정 기록기(JudgeReport)
판정기가 투구마다 내린 판정들을 기록한다.
- 특정 판정(Judgment)에 대한 카운팅과 카운트 확인이 가능하다.
- 판정 기록기(JudgeReport)에서 스트라이크가 3개면 게임이 완료 상태가 되었다는 것을 알 수 있다.

### 판정(Judgment) - enum
스트라이크, 볼, 낫싱

### Flow (전체 흐름)
1. 랜덤한 투구들(Pitchings), 판정기(Judge), 판정 기록기(JudgeReport)를 가지고 있는 게임(Game)을 생성한다.
2. 입력으로 받은 3자리 숫자로 만든 투구들(Pitchings)을 게임(Game)에 알려주고 판정기(Judge)를 작동시킨 결과를 판정 기록기(JudgeReport)에 기록한다.
3. 판정 기록기(JudgeReport)에 기록된 판정 기록을 보고 3 스트라이크인지 확인한다.
4. 3 스트라이크가 아니면 2, 3번을 반복한다.
5. 3 스트라이크면 게임(Game)을 종료하고 새로 시작할지 프로그램을 종료할지 선택한다.
6. 새로 시작할 경우 1번으로 돌아간다.

## 🤔 생각해보기
#### 자주 쓰이는 객체는 캐싱하자!
- 투구(Pitching)를 최소 값에서 최대 값까지 미리 만들어 놓고 가져다 쓰도록 하였다.
#### 로직에서 굳이 새로운 객체를 만들 필요가 없고 상태 값이 존재하지 않는 객체는 싱글톤으로 만들어보는건 어떨까?
- 판정 규칙(JudgeRule)의 구현체들을 싱글톤으로 만들었다.
#### 새로운 판정 규칙이 추가된다면?
- 새로운 판정 규칙이 추가될 경우 해당 규칙을 싱글톤으로 만들고 판정 규칙 생성기(JudgeRuleFactory)에 있는 생성 메서드의 반환 리스트에 해당 인스턴스를 추가하여 확장에는 열려있고 기존 코드의 수정을 최소화 할 수 있도록 하였다.
#### 랜덤한 숫자의 투구들(Pitchings)을 투구들(Pitchings)의 static 팩토리 메서드로 생성하는게 맞을까? 아니면 랜덤 투구들 생성기(RandomPitchingsGenerator)를 만들어서 여기에서 생성을 해주는게 맞을까?
- 투구들을 생성하는 방법이 랜덤한 방법 외에도 다른 방법들이 추가되어야 한다면 투구들 생성기(PitchingsGenerator)를 구현하는 구현체들을 만드는게 맞지만, 현재 요구사항에서는 간단히 투구들(Pitchings)의 static 팩토리 메서드로 생성하는 방식을 사용했다.

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
