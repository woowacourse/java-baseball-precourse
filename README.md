# 미션 - 숫자 야구 게임

우아한테크코스 1주차 미션

## 💁‍♂️ Wiki & Notion 

- 📌 [미션 내용](https://github.com/maprk/java-baseball-precourse/wiki/Mission-Contents)
- 📅 [과제 계획](https://github.com/maprk/java-baseball-precourse/wiki/Plan-List)
- 🔍 [문제 분석](https://github.com/maprk/java-baseball-precourse/wiki/Problem-Analysis)
- 📎 [참고 자료](https://github.com/maprk/java-baseball-precourse/wiki/Reference)
- 📚 [공부한 내용](https://github.com/maprk/java-baseball-precourse/wiki/Study)
- 🗒 [개발 일지](https://github.com/maprk/java-baseball-precourse/progress)
- ✔️ [Notion Link](https://tricolor-silk-b6e.notion.site/woowacourse-cd272b35cbfc448d88a47d1a338fee14)

## 구현할 기능 목록

### game domain

- 숫자 야구 게임 관리
    - 숫자 야구 게임을 시작하고, 재시작하는 관리자 역할을 수행한다.
    - [BaseballGameManager](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/game/BaseballGameManager)
- 숫자 야구 게임 진행
    - 게임이 시작되고 게임을 진행하는 역할을 수행한다.
    - [BaseballGame](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/game/BaseballGame)
- 볼/스트라이크 개수 체크
    - 게임 진행중 사용자 숫자와 컴퓨터 숫자를 비교하는 역할을 수행한다.
    - [CheckBaseballNumber](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/game/CheckBaseballNumber)
- 재시작 옵션
    - 게임이 종료되고, 재시작 여부를 판단하는 역할을 수행한다.
    - [RestartOption](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/game/RestartOption)

### input domain 

- 사용자 야구 숫자 입력
    - 사용자 야구 숫자 입력이 이루어지는 곳이다.
    - [BaseballNumberInput](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/input/BaseballNumberInput)
- 재시작 숫자 입력
    - 야구 게임이 종료되고, 재시작 숫자 입력에 이루어지는 곳이다.
    - [RestartNumberInput](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/input/RestartNumberInput)

### model domain 

- 숫자 생성을 위한 인터페이스
    - 추상 팩토리 패턴을 적용해 사용자 숫자, 컴퓨터 숫자를 위한 인터페이스다.
    - [BaseballFactory](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/model/BaseballFactory)
- 입력을 위한 인터페이스
    - 추상 팩토리 패턴을 적용해 사용자 야구 숫자 입력, 재시작 숫자 입력을 위한 인터페이스다.
    - [InputFactory](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/model/InputFactory)
- 최종 게임 결과 컨테이너
    - 최종 결과를 만들어내는 역할을 수행한다. -> 볼 개수, 스트라이크 개수
    - [ResultContainer](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/model/ResultContainer)

### number domain

- 컴퓨터 랜덤 숫자 생성
    - 컴퓨터 숫자를 생성하는 역할을 수행한다.
    - [ComputerNumber](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/number/ComputerNumber)
- 사용자 숫자 생성
    - 사용자 숫자를 배열로 변환하고 검증하는 역할을 수행한다.
    - [UserNumber](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/number/UserNumber)

### output domain 

- 출력할 메서드 모음
    - 출력을 담당하는 클래스다.
    - [Output](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/output/Output)
- 출력 메시지
    - 열거형으로, 출력 메시지를 담고있다.
    - [PrintMessage](https://github.com/maprk/java-baseball-precourse/tree/main/src/main/java/baseball/output/PrintMessage)

## 설계 방향

- 다양한 디자인 패턴 적용
- SRP 원칙 준수
- 컨벤션 규칙 준수 
