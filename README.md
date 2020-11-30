## 기능 구현 목록
- 임의 3자리 수 생성 후 Opponent 객체 생성
- User에게 3자리 수 받은 후 User 객체 생성
- 예외 사항
   - 입력한 숫자가 3자리 수가 아닌 값 입
   - 1 ~ 9의 숫자가 아닌 값 입력
   - 중복된 값 입력
 
 - 출력
   - Opponent 객체와 User객체가 가지고 있는 Baseball로 볼, 스트라이크, 낫싱 계산 후 힌트 출력
        
- 3스트라이크일시 게임 종료.
- 게임 종료후 재시작 또는 완전 종료 질문
- 1 또는 2가 아닌 경우 예외 처리


## 클래스별 기능
##### Baseball.java
- Baseball 정보를 저장. (Arraylist)
- 인풋을 파싱하여, validate한다.

##### Constants.java
- Application에서 쓰이는 constant를 모아놓음.

##### Game.java
- 게임 구동 로직 구현. 

##### GameManager.java
- 유저와 Opponent사이의 게임 결과 도출.

##### Player.java
- User와 Opponent를 상속하기 위한 부모.

##### Opponent.java
- Player로 부터 상속받으며 Baseball을 가지고 있는 클래스.

##### User.java
- Player로 부터 상속받으며 Baseball을 가지고 있는 클래스.

##### Validation.java
- input을 validate하는 static 클래스.
