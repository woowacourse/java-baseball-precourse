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
  - 아는 것
    - Computer : randomNumber 생성 및 볼 카운트 판단
    - Player : 값을 입력하는 게임 참여자
  - 하는것
    - playGame() : 게임 시작
    - decideNextGame() : 게임을 한판 더 할지 안할지 결정
    
4. Computer
  - 아는 것
    -randomNumberList : randomNumber를 저장하는 list
  - 하는 것
    - decideRandomNumber() : 1~9로 이루어진 3자리 수 생성
    - canFinish(int predict) : 사용자가 예측한 수를 입력받아 Ballcount를 출력하고 끝낼수 있는지 없는지 판단  
    
4. Player
  - 하는 것 
    - predictNumber() : 사용자가 예측한 입력값을 받고 validation을 거친 뒤 반환
    - decideGoOrStop() : 사용자의 입력값을 받아 validation을 거친 뒤 REPEAT = 1 or STOP = 2 를 반환

5. Validation - 예외발생 시 IllegalArgumentException 반환
  - 하는 것
    - isRightDigit(String input) : 입력값이 숫자인지 아닌지 판단
    - isValidRange(int value) : 사용자가 3자리 숫자를 입력했는지 아닌지 판단
    - containZero(int value) : 입력된 수에 0이 포함되어 있는지 아닌지 판단
    - isPermittedInput(int value) : REPEAT = 1 or STOP = 2 로만 입력 되었는지 아닌지 판단

6. SystemMessage : constant를 모아놓은 클래스

### 클래스 다이어그램
<img width="519" alt="스크린샷 2021-11-26 오후 1 40 00" src="https://user-images.githubusercontent.com/68465557/143534159-4d23d428-ac43-429c-8a74-c16b6fc94020.png">
