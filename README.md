# ⚾ 숫자 야구 게임

## 📢 기능 구현 목록

- [x] [랜덤값생성]1 ~ 9 까지의 서로 다른 임의의 수 3개를 생성한다.
    
    - [x] RandomUtils 클래스를 이용하여 임의의 수 3개를 생성한다.
    - [x] [예외처리]서로 다른 숫자를 가져야한다.
    
- [x] [입력처리]정답을 맞추기 위한 3자리수를 입력받는다.
    
    - [x] 비정상적인 입력에 대해서는 `IllegalArgumentException`을 유도
    - [x] [예외처리]3자리수가 맞는 지 확인
    - [x] [예외처리]'1' ~ '9' 까지의 입력 중 하나인지 확인
    - [x] [예외처리]3자리 중 중복되는 숫자가 있는 지 확인
    
- [x] [입력값 검사]정답이 아닌 경우 입력값에 대한 `볼`, `스트라이크`, `낫싱` 총 3개의 힌트가 제공된다.
    
    - [x] `볼` : 다른 자리에 숫자가 있는 경우
    - [x] `스트라이크` : 같은 자리에 같은 숫자가 있는 경우
    - [x] `낫싱` : 같은 숫자가 하나도 없는 경우
    
- [x] [입력값 검사]입력값이 정답인 경우 게임이 종료, 정답이 아닌 경우 2번으로 다시 이동한다.
- [x] [재시작/종료 처리]게임 종료 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
    - [x] [예외처리]1은 게임 재시작, 2는 게임 종료를 실행하고 그 외에는 예외처리해준다.

<br>

### 🎃 프로그램 구성 요소

- 📁 baseball
    - 📁 domain
        - 📃 GameType : Game에 관한 정보 (게임시작=1, 게임종료=2)
        - 📃 Number : 숫자에 관한 정보 (숫자 길이, 숫자 범위)
        - 📃 NumberGenerator : 랜덤 숫자 생성 제너레이터
    - 📁 service
        - 📁 ui
            - 📃 Output : 출력 기능 담당
            - 📃 Input : 입력 기능 담당
        - 📃 BaseballGame : 숫자 야구 게임 실행
        - 📃 Hint : 게임 힌트 제공 

    - 📃 Application : 프로그램 실행
- 📁 utils
    - 📁 validator
        - 📃 NumberValidator : 숫자 검사 (문자가 숫자인지, 길이가 3인지 확인)
        - 📃 DuplicateValidator : 숫자가 중복되는지 검사
        - 📃 RestartValidator : 재시작 값이 유효한 숫자인지 검사
    - 📃 RandomUtils : 랜덤 숫자를 제공하는 기능 담당
    - 📃 InputConverter : 문자를 숫자 리스트로 변경해주는 기능 담당
 
<br>       

### 🚨 유의 사항

아래의 사항들은 반복적으로 체크해야할 리스트입니다. <br>

<details>
<summary> ✍ CHECK LIST ✍ </summary>

<br>

- [x] Indent Depth는 최대 2까지만 허용
- [x] 함수의 길이는 10라인 이하
- [x] `else` 예약어 X
- [x] `public`/`protected`/`private`/`package` 용도에 맞게 구현
- [x] 이름을 통해 의도 드러내기, 축약 금지
- [x] 개발 도구의 code format : 단축키 `Ctrl+Alt+L(윈도우)`
- [x] 반복되는 내용을 최소화
- [x] 의미있는 커밋 메세지 작성
- [x] README.md를 상세히 작성
- [x] 기능 목록 구현 재검토 (예외 사항도 정리)
- [x] 세세한 부분은 수정될 수 있으므로 구현 기능에 초점
- [x] 구현 순서도 Convention
- [x] JAVA API 적극 활용하기
- [x] 적절한 Collection 활용하기 : `List`, `Map`, `Set`
- [x] 객체에 메세지를 보내기 : 상태 데이터를 가진 객체가 데이터를 꺼내는 것이 아닌, 객체가 메시지를 전달해줄 수 있도록 작성
- [x] 필드(인스턴스 변수)의 수를 줄이기 위해 노력한다
- [x] 비즈니스 로직과 UI 로직을 분리
- [x] 주석은 꼭 필요한 경우만 작성
- [x] 상황(context)에 맞는 설계와 구현 방법을 찾기
- [x] 반복문 대신 재귀 함수 구현 가능
- [x] 원시타입 문자열을 포장
- [x] 일급 콜렉션 적용
- [x] 3개 이상의 인스턴스 변수를 가진 클래스 구현 X
- [x] 메소드 인자수 3개 이하로 제한
- [x] 메소드가 한 가지 일만을 담당
- [x] 클래스 작게 만들기

- [[추가] 참고 블로그](https://hodol.dev/posts/%EC%9A%B0%EC%95%84%ED%95%9C%ED%85%8C%ED%81%AC%EC%BD%94%EC%8A%A4-%ED%94%84%EB%A6%AC%EC%BD%94%EC%8A%A4-%EC%A4%80%EB%B9%84)

<br>

- 내용 정리
- [1. JAVA Code Convetion 이해하기 🧐](https://velog.io/@bosl95/JAVA-Code-Convention)
- [2. Commit Message Convention 이해하기 👾](https://velog.io/@bosl95/Commit-Message-Convention)
- [3. SOLID 이해하기 🥳](https://velog.io/@bosl95/SOLID-%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EC%84%A4%EA%B3%84)
- [4. 객체지향 디자인 패턴 이해하기](https://velog.io/@bosl95/%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5-%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4)

</details>

<br>
<br>

## 👻 미션 요구사항 (원문과 중복)

<details>
<summary> 👉 클릭 </summary>

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

</details>