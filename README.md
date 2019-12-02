# 기능 목록

  * BaseBallApp
    - main() : Game 객체를 생성하고 게임을 시작
    
  * BaseballGame
    - gameStart() : 게임 실행 로직
    - askGameAgain() : 게임 다시시작/종료 여부
    
  * Score
    - init() : strike / ball 점수 초기화
    - getStrike() : 멤버변수 strike 의 getter method
    - calculateWinning(ball, ball) : win 판단
    - calculateScore() : 점수 계산
    - printScore() : 현재 점수 출력
    
  * Ball
    - 생성자 오버로딩
    - 멤버변수인 numbers의 getter
    
  * BallPlayer : Interface
    - prepareBall() 
    - getBall()
    
  * ComputerPlayer : BallPlayer 구현체
    - prepareBall() : 랜덤한 3자리 숫자 생성
    - getBall() : 멤버변수 ball의 getter method
    
  * UserPlayer : BallPlayer 구현체
    - prepareBall() : 입력으로 받은 3자리 숫자 생성
    - parseInput(userInput) : 입력으로 받은 문자열을 List로 리턴
    - getBall() : 멤버변수 ball의 getter method
