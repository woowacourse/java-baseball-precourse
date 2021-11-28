# 미션 - 숫자 야구 게임

## 기능 구현 사항:
1. 1 ~ 9로 이루어진 3자리 수를 생성
2. 플레이어가 3개의 숫자를 입력하는 기능
3. 스트라이크 / 볼 / 낫싱을 판단하는 기능
4. 상대방의 3가지 숫자를 모두 맞추면 게임 종료
5. 게임이 종료된 뒤 다시 시작하거나 종료할 수 있는 기능

## 예외 처리 사항:
1. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생 후 애플리케이션 종료
  - 숫자가 1~9 이외의 숫자로 이루어진 경우
  - 숫자가 3자리수가 아닌 경우

-----------
## 구현 후 총정리

### 클래스 및 퍼블릭 인터페이스 설명
1. Application : 어플리케이션 실행
2. BaseBall
  - playGame() : 게임 시작(전체적 흐름)
  - decideNextGame() : 게임을 한판 더 할지 안할지 결정
    
3. RandomNumberGenerator 
  - generateRandomNumber() : 3자리 난수 생성 
  
4. Referee
  - canFinish(int predict) : 사용자가 숫자를 모두 맞추었는지 판단  
  - calculateBallCount(int randomNumber, int predict) : 난수와 예측값을 비교해서 Ballcount를 계산하는 메서드
    
5. BallCount
  - plusStrike, plusBall() 
  - isStrikeOut() : 사용자가 3자리 숫자를 모두 맞추었는지 확인 메서드
  - printCurrentBallCount() : 사용자에게 Ballcount를 출력하느 메서드
 
6. PlayerInput : 사용자 입력 추상화
  - PredictInput, DecideNextInput : PlayerInput 구체화 클래스 
     - getPlayerInput() : 사용자가 예측한 입력값을 받고 validation을 거친 뒤 정수 값 반환
     - abstract boolean isSatisfiedBy(CurrentState state) : 어플 상태에 따라 다른 입력값 받음
     - abstract void printInputMessage() : 어플 상태에 따라 다른 메세지
     - abstract void isValidInput(String userInput) : 사용자 입력에 따라 다른 validation 절차



7. Validation - 예외발생 시 IllegalArgumentException 반환
  - isRightDigit(String input) : 입력값이 숫자인지 아닌지 판단
  - isValidRange(int value) : 사용자가 3자리 숫자를 입력했는지 아닌지 판단
  - containZero(int value) : 입력된 수에 0이 포함되어 있는지 아닌지 판단
  - isPermittedInput(int value) : REPEAT = 1 or STOP = 2 로만 입력 되었는지 아닌지 판단

6. SystemMessage : constant를 모아놓은 클래스 , Enum CurrentState : 어플 현재 상태

### 클래스 다이어그램
<img width="1077" alt="스크린샷 2021-11-28 오후 10 17 19" src="https://user-images.githubusercontent.com/68465557/143770417-4b489fd5-ea30-4fb8-8b65-ecd56fe01e0f.png">
