# 미션 - 숫자 야구 게임

## 🔍 진행방식

- 미션은 **기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항** 세 가지로 구성되어 있다.
- 세 개의 요구사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.

<br>

## 📑 기능 목록 정의

### Computer: 컴퓨터
- 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성
- 볼, 스트라이크 카운팅
- 유효성 검사
  - 길이가 3자리 인지
  - 중복된 숫자가 있는지

### Game
- 재시작/종료 숫자 검사
  - 1 이면 재시작
  - 2 이면 종료

### Round
- 메시지 출력
  - `숫자를 입력해주세요`
  - `x볼 x스트라이크`/`x볼`/`x스트라이크`
  - `낫싱`
  - `3개의 숫자를 모두 맞히셨습니다! 게임 종료`
- 숫자 유효성 검사
  - 길이가 3자리 인지
  - 숫자 이외의 문자가 있는지 확인
  - 중복된 숫자가 있는지
  - 검증 실패: IllegalArgument 발생

<br>



## ✅ 요구사항 점검
### 기능 요구사항
- [ ] Hint가 잘 동작한다.(스트라이크/볼/낫싱)
- [ ] 사용자가 입력을 잘못한 경우 `IllegalArgumentException` 발생 시킨 후 종료
- [ ] 게임을 종료한 후 재시작/완전종료 선택할 수 있다.

### 프로그래밍 요구사항
- [ ] 프로그램의 실행 시작점은 `Application`의 `main()`
- [ ] 3항 연산자를 사용하지 않는다.
- [ ] depth가 2이하
- [ ] 프로그램 구현을 완료했을 때, `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공했는가

### 과제 제출 전( 0점 방지 )
- [ ] 터미널에서 `java -version` 실행해서 JDK 버전 8인지 확인
- [ ] Eclipse에서 JDK, JRE 버전 8인지 확인
- [ ] JDK가 제공하는 Random, Scanner API 대신 `capm.nextstep.edu.missionutills`의 Randoms, Console API 사용
- [ ] 윈도우 사용자의 경우 터미널에서 `gradlew.bat clean test` 실행 시 모든 테스트가 통과되는지 확인

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

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
