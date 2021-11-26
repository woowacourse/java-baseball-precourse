# 구현할 기능

## 사용자로부터 입력 구현

- 사용자의 숫자 입력을 받는다.
  - 예외처리1. `0` 혹은 `숫자가 아닌 것`을 입력한 경우
  - 예외처리2. `숫자를 중복`하여 입력한 경우
- 게임 한 turn 종료 후, 사용자로부터 재시작 여부를 입력 받는다.
  - 예외처리1. 1(재시작) 혹은 2(종료) 외의 값을 입력한 경우



## 게임 상대방(컴퓨터)의 동작 구현

- 1~9 사이의 서로 다른 난수 3개(정답)를 생성한다.
- 사용자가 입력한 수와 정답을 비교하여, 힌트를 제시한다.
  - `스트라이크` : 같은 수가 같은 자리에 있다.
  - `볼` : 같은 수가 다른 자리에 있다.
  - `포볼` 혹은 `낫싱` : 같은 숫자가 하나도 없다.
- 정답을 입력한 경우, 재시작 여부를 묻는다.
  - `1` : 게임 재시작
  - `2` : 게임 종료



-------------------------

## 개발 일지

### DAY01

- **구현**
  - 난수 생성 클래스 생성
  - 큰 틀에서 main 함수의 flow 구현
- **남은 작업**
  - 사용자의 잘못된 입력에 대한 예외 처리
  - 문제의 제약사항 지키지 않는 부분 수정 (ex Scanner 사용하면 안됨 등)



### DAY02

- **구현**
  - Validator 클래스 생성
    - 사용자의 잘못된 입력에 대한 예외 처리
  - 문제에서 요구하는 API로 수정
    - 랜덤 관련
      - `java.util.Random` -> ``camp.nextstep.edu.missionutils.Randoms`
    - 사용자 입력 관련
      - `java.util.Scanner` -> `camp.nextstep.edu.missionutils.Console`
- **남은 작업**
  - 인코딩 관련 문제 해결 ('UTF-8')
    - 터미널에서 test 작동하지 않는 문제 해결해야 함 (`./gradlew clean test`)
  - java 코딩 컨벤션 - 새줄문자 lf 관련 : `.gitattribute` 작성