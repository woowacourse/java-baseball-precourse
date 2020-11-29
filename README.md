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

## 구현할 기능 목록
1. 세자리 랜덤 숫자를 뽑음 (makeThreeRandNum)
    - 중복 여부는 체크하지 않음

2. 랜덤 숫자 중복을 검사 (checkDuplication)
    - 중복이면 false, 중복이 아니면 true 반환

3. 유효성 검증된 랜덤 숫자 생성 (randNumList)
    - 세자리 랜덤 숫자를 뽑고, 유효성을 검증하여
    - 최종 세자리 랜덤 숫자를 각 자리를 분리하여 리스트로 반환

4. 나의 입력값이 세자리 숫자인지 아닌지의 여부를 알려줌 (notInputThreeDigit)
    - 세자리 숫자일때 false, 아닐 때 true를 반환
    
5. 나의 입력값 숫자 중복 검사 (checkDuplication)
    - 각 자리수의 숫자가 중복되는지 검사
      중복이면 true, 중복이 아니면 false 반환
      
6. 나의 입력값 0이 들어있는지 검사 (inputZero)
    - 세 숫자 중 0이 들어있는지 검사
      들어있으면 true, 아니면 false 반환

7. 나의 입력값 숫자 생성 (makeThreeMyNum)
    - 입력값의 앞에서 세자리까지 숫자 리스트로 반환
    - 유효성 검증이 되지 않았음

8. 유효성 검증된 나의 숫자 생성 (myNumList)
    - 세자리인지 검증하여 아닐 시 IllegalArgumentException 발생
    - 세자리 검증 후 입력값 숫자 생성
    - 중복검사하여 중복일시 IllegalArgumentException 발생
    - 유효성 검증된 세자리 숫자를 각 자리로 분리하여 리스트로 반환
   
9. 스트라이크 횟수 반환 (strike)
    - 랜덤 숫자 리스트, 나의 숫자 리스트 비교
    - 인덱스와 값이 같을시 스트라이크

10. 볼 횟수 반환 (ball)
    - 랜덤 숫자 리스트, 나의 숫자 리스트 비교
    - 인덱스와 값이 다를시 볼
    
11. 볼, 스트라이크, 게임 결과 출력 (result)
    - 볼, 스트라이크 횟수 출력
    - 3스트라이크일시 메시지 출력
    
12. 3스트라이크인지 아닌지 알려줌 (threeStrike)
    - 3스트라이크일시 true, 아닐시 false 반환
    
13. 메인함수 구현 (완료)
    
## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
