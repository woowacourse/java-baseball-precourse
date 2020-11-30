# 미션 - 숫자 야구 게임 / 김진환

## 기능 목록

- #### Target Number 설정
    - 프로그램이 임의로 1~9까지의 서로 다른 수 3개를 정한다.

- #### 사용자 입력
    - 사용자 추측 숫자로, 1~9까지의 임의의 수를 3개를 입력 받는다.
    - 게임의 재진행 여부 확인으로, 구분 수(1 또는 2)를 입력 받는다. 

- #### 예외 처리
    - 사용자 추측 입력 문자열이 지정된 개수(3개)를 벗어난 길이를 갖는 경우 
    - 사용자 추측 입력 문자열이 유효 문자 범위(1~9)를 벗어난 경우
    - 사용자 추측 입력 문자열의 3개의 수에 중복이 존재하는 경우
    - 게임 재진행 여부 구분자 입력이 유효 문자 범위(1~2)를 벗어난 경우
    
- #### 야구 게임 룰 구현
    - 야구 게임의 룰에 따라, 사용자 추측 수의 점수를 계산한다.
    - 같은 수, 같은 자리 : 스트라이크
    - 같은 수, 다른 자리 : 볼
    - 모두 같은 수인 경우 : 승리
    
- #### 출력
    - 사용자 추측 문자열에 대한 점수 표시
    - 승리 시 메시지 출력
    - 재진행 여부 / 게임 종료 메시지 출력
   
<br>

## 프로그램 구조

- #### baseball
    - Application : BaseballGame 플레이 여부를 결정한다. 
    - BaseballGame : 사용자 입력을 받아 점수를 출력함을 종료 전까지 반복한다.
    - GameRule : 사용자 입력과 컴퓨터 입력을 비교하여 점수를 계산하고 승리 여부를 판별한다.
    - Numbers : 지정된 범위(1~9)의, 지정된 개수(3)의 수 리스트를 저장한다.
    - PlayButton : 사용자가 게임 진행을 더 할건지 여부를 저장한다.
    - Score : 사용자가 추측한 수의 점수(스트라이크와 볼의 개수)를 저장한다.
    
- #### utils
    - InputValidator : 사용자 입력이 유효한지 검증한다.
    - NumbersFactory : 새로운 Numbers를 생성하거나, 사용자가 입력한 문자열로 Numbers를 생성한다.
    - RandomUtils : 범위 내 임의의 숫자를 리턴한다.
    - StringHandler : 사용자의 입력을 다루기 위한 문자열 처리 메소드를 포함한다.
    
- #### view
    - InputView : 사용자로부터 입력을 받는다.
    - OutputView : 메시지를 출력한다.
    
<br>

## 미션 요구 사항

<details>
<summary> 접기 / 펼치기 </summary>
  
## 기능 요구사항

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

</details>
