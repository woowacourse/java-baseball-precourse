## 🔥 구현할 기능 목록

- 컴퓨터의 answerNumber 생성
  - `camp.nextstep.edu.missionutils.Randoms` API사용하여 랜덤 숫자 생성
- 유저의 inputNumber 입력
  - `camp.nextstep.edu.missionutils.Console` API를 사용하여 입력받음
  - 예외처리
    - 3자리 숫자가 아닐경우 `IllegalArgumentException`
    - 입력된 숫자중 중복이 있을 경우 `IllegalArgumentException`
- 볼 / 스트라이크 출력
  - 유저가 입력한 inputNumber와 컴퓨터의 answerNumber를 비교하여 볼 / 스트라이크 카운팅
  - 3스트라이크일 경우 정답처리. 게임 종료
  - 3스트라이크가 아닐 경우 힌트 출력
    - 0볼 0스트라이크면 `낫싱` 출력
    - 볼이나 스트라이크중 하나만 0인 경우 빼고 출력 ex) `n볼` , `m스트라이크`
    - 둘 다 1이상의 값인 경우 `n볼 m스트라이크` 형식으로 출력
- 게임 재시작 여부 선택
  - 멘트 출력
  - `camp.nextstep.edu.missionutils.Console` API를 사용하여 1(다시시작) 또는 2(게임종료)를 입력받음
    - 예외처리
      - 입력값이 1 또는 2가 아닐 경우 `IllegalArgumentException`
  - 1 입력시 새 게임 시작, 2 입력시 프로그램 종료


