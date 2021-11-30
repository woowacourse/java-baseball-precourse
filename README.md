# 미션 - 숫자 야구 게임

## ✔️ 과제 제출 전 체크리스트 - 0점 방지

- [x] 터미널에서 `java -version`을 실행해 자바 8인지 확인한다. 또는 Eclipse, IntelliJ IDEA와 같은 IDE의 자바 8로 실행하는지 확인한다.
- [x] 터미널에서 맥 또는 리눅스 사용자의 경우 `./gradlew clean test`, 윈도우 사용자의 경우 `gradlew.bat clean test` 명령을 실행했을 때 모든 테스트가 통과하는지 확인한다.

---

## 🚀 기능 요구사항

> 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
>
> - 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    >   - 예) 상대방(컴퓨터)의 수가 425일 때
    >     - 123을 제시한 경우 : 1스트라이크
    >

- 456을 제시한 경우 : 1볼 1스트라이크

>     - 789를 제시한 경우 : 낫싱
> - 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
> - 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
> - 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
> - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
> - 아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.

### 게임 플로우

1. 유저는 게임을 시작한다
2. 컴퓨터는 서로 다른 세 자리 수 정답을 생성한다.

- 각 자리 수는 서로 다른 수로 생성

3. 유저는 세 자리 수를 입력한다.
4. 유저의 입력 값을 검증한다.
5. 검증 결과에 따라 아래의 플로우를 따른다.

- 검증을 통과할 경우 6.으로
- 통과하지 못하는 경우 IllegalArgumentException 발생, 애플리케이션 종료

6. 입력값을 정답과 비교한다.
7. 비교 결과에 따라 아래의 플로우를 따른다.

- 정답인 경우 8.로
- 정답이 아닌 경우 힌트 제시 후 3.으로

8. 유저는 게임 종료, 재시작에 해당하는 코드값을 입력한다.

- 1을 입력한 경우 재시작, 2.로
- 2를 입력한 경우 게임 종료

### 입력 값 평가

- 각 자리 수가 가질 수 있는 상태
    - STRIKE : 같은 수가 같은 자리
    - BALL : 같은 수가 다른 자리
    - WRONG : 다른 수

- 세 자리 수 평가
    - 스트라이크 3개 : 정답
    - WRONG 3개 : 낫싱
    - 그 외 : M볼 N스트라이크

### input 검증

1. 유저가 제시한 값

- 입력값은 3자리 수
- 3자리는 서로 다른 수

2. 게임 종료 or 재시작

- 1 혹은 2 두 가지의 값만 통과

<br>

---

## 🎱 프로그래밍 요구사항

- [x] 프로그램을 실행하는 시작점은 `Application`의 `main()`이다.
- [x] JDK 8 버전에서 실행 가능해야 한다. **JDK 8에서 정상 동작하지 않을 경우 0점 처리**한다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - https://naver.github.io/hackday-conventions-java
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.

### 프로그래밍 요구사항 - Randoms, Console

- [x] JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야
  한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- [x] 프로그램 구현을 완료했을 때 `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**

<br>

---

## 📈 과제 진행 요구사항

- [x] 미션은 [java-baseball-precourse](https://github.com/woowacourse/java-baseball-precourse) 저장소를 Fork/Clone해 시작한다.
- [x] **기능을 구현하기 전에 java-baseball-precourse/README.md 파일에 구현할 기능 목록을 정리**해 추가한다.
- [x] **Git의 커밋 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위**로 추가한다.
    - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를
      남긴다.
- [x] 과제 진행 및 제출 방법은 [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 를 참고한다.

<br>

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.