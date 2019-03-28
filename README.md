# 우아한테크코스

우아한 테크코스 첫번째 과제 "숫자야구게임" 프로젝트 입니다. 


## 기능 목록

함수별 구현 기능 명세

- **startGame()**: 게임 시작 함수
- **createComputerAnswer()**: 컴퓨터의 정답 생성
- **getUserInput()**: 유저로부터 조건에 맞는 입력을 받는 함수
- **checkUserInput(String inputStr)**: 유저의 입력을 받아 반환하는 기능. 유저의 입력이 조건에 맞지 않으면 입력을 재요청 한다.
- **getStrikeCount(String a, String b)**: 컴퓨터의 String과 유저의 predict를 비교해 Strike 갯수를 반환한다.
- **getBallCount(String a, String b)**: 컴퓨터의 String과 유저의 predict를 비교해 ball 갯수를 반환한다.
- **printResponse(int strikeCount, int ballCount)**: strike, ball 갯수를 입력받아 그에맞는 반응을 출력
- **getRestartAnswer()**: 사용자로부터 1혹은 2를 입력받아 재시작할지 여부를 반환한다
