# 미션 - 숫자 야구 게임

## 🔍 진행방식

- 미션은 **기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항** 세 가지로 구성되어 있다.
- 세 개의 요구사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.

## ✔️ 과제 제출 전 체크리스트 - 0점 방지

- 터미널에서 `java -version`을 실행해 자바 8인지 확인한다. 또는 Eclipse, IntelliJ IDEA와 같은 IDE의 자바 8로 실행하는지 확인한다.
- 터미널에서 맥 또는 리눅스 사용자의 경우 `./gradlew clean test`, 윈도우 사용자의 경우 `gradlew.bat clean test` 명령을 실행했을 때 모든 테스트가 통과하는지 확인한다.

---

## 🚀 기능 요구사항

## 기능 목록

### 랜덤한 3자리 수 생성

- 1~9의 range 내의 수로 구성
- 중복되지 않은 수로 구성

### 사용자 입력

- 1~9의 range 내의 수로 구성
- 3자리 수로 구성
- 잘못 된 값을 입력 할 경우 `IllegalArgumentException`을 발생

### 룰 적용

- 같은 자리에 같은 숫자 → 스트라이크
- 다른 자리에 같은 숫자 → 볼
- 볼, 스트라이크 x → 낫싱
- 3 스트라이크 → 종료

### 게임 종료

- 3 스트라이크 후 재시작/종료


