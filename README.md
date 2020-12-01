# 미션 - 숫자 야구 게임 (후기 블로그 : https://jayb-log.tistory.com/163)

## 🚀 기능 구현 목록
- [x] RandomUtils를 이용해 숫자 야구의 정답을 생성하는 generator 구현
- [x] 사용자의 입력이 정확한지 판단하는 validator 구현
- [x] 사용자의 입력을 받는 것을 구현
- [x] 적합한 입력일 경우 generator를 통해 생성된 결과와 입력 받은 숫자를 비교하여 결과를 출력해주는 로직을 구현
    - 같은 자리에 같은 숫자가 있는 경우를 '스트라이크' 
    - 다른 자리에 숫자가 있는 경우를 '볼'
    - 같은 숫자가 하나도 없는 경우 힌트로 '낫싱'
- [x] 하나의 게임이 종료될 경우 반복, 또는 게임 완전 종료 여부를 묻고 실행하는 로직을 구현
    - 3자리 숫자가 정답과 같은 경우 게임이 종료
    - 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료



<br>

## 🎱 프로그래밍 요구사항
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x] System.exit 메소드를 사용하지 않는다.
- [x] 비정상적 입력에 대해서는 IllegalArgumentException을 발생시킨다.

### 프로그래밍 요구사항 - Application
- [x] Application 클래스를 활용해 구현해야 한다.
- [x] Application의 패키지 구조와 구현은 변경하지 않는다.
- [x] `final Scanner scanner = new Scanner(System.in);`는 변경하지 않는다.
- [x] `// TODO 구현 진행` 이 후 부터 구현한다.



### 프로그래밍 요구사항 - RandomUtils
- [x] RandomUtils 클래스를 활용해 랜덤 기능을 구현해야 한다.
- [x] RandomUtils의 패키지 구조와 구현은 변경하지 않는다.

<br>

## 📈 진행 요구사항
- [x] 미션은 [java-baseball-precourse 저장소](https://github.com/woowacourse/java-baseball-precourse) 를 fork/clone해 시작한다.
- [x] 기능을 구현하기 전에 java-baseball-precourse/README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- [x] git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
  - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.
- [x] [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 절차를 따라 미션을 제출한다.

<br>

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
