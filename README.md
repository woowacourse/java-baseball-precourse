# 기능 목록

  * BaseBallApp
    - main() : Game 객체를 생성하고 게임을 시작
    
  * Game
    - gameStart() : 게임 실행 로직
    - gameAgain() : 게임 다시시작/종료 여부
    
  * Score
    - init() : strike / ball 점수 초기화
    - calculate(ball, ball) : 점수 계산
    
  * Computer
    - generateRandomBall() : 랜덤한 3자리 숫자 생성
    
  * User
    - generateInputBall() : 입력으로 받은 3자리 숫자 생성