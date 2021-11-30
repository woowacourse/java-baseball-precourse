# 우아한 프리코스 1주차 미션: 숫자 야구 게임

## 구현할 기능 목록

1. 게임 종료 후 재시작 혹은 완전 종료를 선택하는 기능

2. 1~9로 구성된 랜덤한 3자리 숫자를 생성하는 기능

3. 플레이어의 입력을 받는 기능

4. 플레이어의 입력에 대해 볼과 스트라이크로 결과를 판단하는 기능

5. 게임 시작 및 정답을 맞췄을 시 종료하는 기능

## 예외 처리

1. 플레이어가 잘못된 값을 입력하였을 경우 IllegalArgumentException을 발생시킨 후 어플리케이션 종료

   * 1~9 이외의 문자를 입력하였을 경우
   * 3자리 숫자가 아닌 경우
   * 게임 종료 후 1 또는 2가 아닌 입력을 하였을 경우

## 파일 목록

### main.java.baseball

   Application.java: 어플리케이션 실행 (main method 위치) 
   
   Game.java: 숫자야구 게임 진행
   
   GameStatus.java: 게임의 현재 상태 저장 및 출력
   
   Player.java: 플레이어. 세 자리 숫자 또는 게임 재시작 여부를 입력
   
   RandomNumberGenerator.java: 1~9로 이루어진 중복이 없는 임의의 세 자리 숫자 생성
   
   StrikeBallCounter.java: 플레이어의 입력에 대해 스트라이크와 볼의 수를 연산 
   
   Validator.java: 플레이어의 입력이 유효한지 검증
   
   Constant.java: 어플리케이션 실행 중 사용되는 상수값을 모아놓은 클래스
   
   SystemMessage.java: 콘솔창에 출력되는 메시지를 모아놓은 클래스

### test.java.baseball

   ApplicationTest.java: 어플리케이션 테스트