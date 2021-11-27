# 미션 - 숫자 야구 게임

## 🔍 진행방식

- 미션은 **기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항** 세 가지로 구성되어 있다.
- 세 개의 요구사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.

## ✉️ 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
  - GitHub을 활용한 제출 방법은 [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 를 참고해 제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원 플랫폼](https://apply.techcourse.co.kr) 에 접속하여 프리코스 과제를 제출한다.
  - 자세한 방법은 [링크](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 를 참고한다.
  - **Pull Request만 보내고, 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## ✔️ 과제 제출 전 체크리스트 - 0점 방지

- 터미널에서 `java -version`을 실행해 자바 8인지 확인한다. 또는 Eclipse, IntelliJ IDEA와 같은 IDE의 자바 8로 실행하는지 확인한다.
- 터미널에서 맥 또는 리눅스 사용자의 경우 `./gradlew clean test`, 윈도우 사용자의 경우 `gradlew.bat clean test` 명령을 실행했을 때 모든 테스트가 통과하는지 확인한다.

---

## 🚀 기능 요구사항

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
  - 예) 상대방(컴퓨터)의 수가 425일 때
    - 123을 제시한 경우 : 1스트라이크
    - 456을 제시한 경우 : 1볼 1스트라이크
    - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
- 아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.

<br>

## ✍🏻 입출력 요구사항

### ⌨️ 입력

- 3자리의 수
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

### 🖥 출력

- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

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
1볼
… 
```

<br>

---

## 🎱 프로그래밍 요구사항

- 프로그램을 실행하는 시작점은 `Application`의 `main()`이다.
- JDK 8 버전에서 실행 가능해야 한다. **JDK 8에서 정상 동작하지 않을 경우 0점 처리**한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - https://naver.github.io/hackday-conventions-java
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.

### 프로그래밍 요구사항 - Randoms, Console

- JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**

<br>

---

## 📈 과제 진행 요구사항

- 미션은 [java-baseball-precourse](https://github.com/woowacourse/java-baseball-precourse) 저장소를 Fork/Clone해 시작한다.
- **기능을 구현하기 전에 java-baseball-precourse/README.md 파일에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위**로 추가한다.
  - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 를 참고한다.

<br>

---
## 💡 구현할 기능 목록
먼저 들어가기에 앞서 Target클래스는 컴퓨터가 랜덤하게 생성한 수와 관련 함수들을 포함하는 클래스이다.
그리고 컴퓨터가 생성한 타겟값은 항상 감춰져 있어야함을 반영해야함을 고려해야한다.

- 💡  gradlew.bat clean test 진행
  

- 💡 **task1. illegalexception 처리**
  - readline()함수 사용
  
  
- 💡 **task2. 게임진행 및 종료 과정 구현**
  - 게임진행과 종료 로직 구현
  - ~~baseball클래스에 Target을 멤버변수로 준비해둔다~~. task3로 옮김.
  - 게임진행은 gameStart()함수로 분리한다.
  

- 💡 **task3. Target클래스 구현**
  - Appilcation 클래스에 Target을 멤버변수로 준비해둔다.
  - 필요한 멤버 변수들 생성
    - int from=1, begin=9, targetLength=3 와 각각에 대한 getter setter 구현
    - targetNumber는 string타입으로 관리한다..
    - string타입인 이유는 추후에 알파벳 등 으로 확장할 때를 위해.
    - targetNumber는 private이고 오로지 target생성함수에 의해서만 생성된다.
  - 생성자에서는 생성되자마자 기본 멤버변수들을 사용해 targetNumber를 생성한다.
  - generateTargetNumber() 구현
    - public void 이고 메게변수는 없다.
    - 멤버변수를 사용하여 적절한 targetNumber를 생성하는 역할을 한다.
    - 구현후 테스트를 거친다. 멤버변수의 조건에 맞게 생성되는지와 항상 바뀌는지 확인한다.
    - (핫픽스) 서로다른 수 이어야함.
  - compareWith(String) 구현
    - public void 이고 매게변수로 사용자 입력값을 받는다.
    - 입력값과 타겟값을 비교하여 한번에 ball과 strike를 계산한다.
    - 계산후에는 배열의 형태로 반환한다.


- 💡 **printResult(int[]) 게임 결과 출력 함수 구현**
  - 크기가 2인 배열을 받고 이를 토대로 ball과 strike를 출력한다.
  - 크기가 2인지 확인해야한다.


- 💡 **gameStart() 게임진행함수의 내부 로직 구현**
  - void 함수이고 게임진행의 전반을 담당한다.
  - Target멤버변수의 타겟값을 생성한다.
  - 반복하여 사용자의 입력을 받고 확인한다.
    - target멤버변수의 targetLength만큼 strike가 나오면 게임을 종료한다.

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
