#구현 기능 목록
<br>

##baseball 패키지 클래스 계층

```aidl
Application

constants
    - MessageConstants
    - ValueConstants

gamesource
    - BaseballGame
    - Opponent

util
    - inputCheck

```
<br>

## 구현 순서

### 1. gamesource.Opponent 클래스 구현
- 난수를 생성하여 필드값으로 가지는 상대방 클래스(Opponent) 구현

### 2. 상수값을 저장하는 constants 패키지 구현
- 문자열 상수만을 가지는 MessageConstants 클래스
- 정수 값을 상수로 가지는 ValueConstants 클래스

### 3. 하나의 게임을 관리하는 gamesource.BaseBallGame 클래스 구현
- 게임을 한 판 실행시키는 gameStart()
- 사용자 입력과 난수를 비교하는 numberCheck()
- 비교한 정보를 출력하는 printScore()

### 4. 게임의 재실행 여부를 확인하는 Application 클래스
- 게임 종료 후 사용자 입력을 받아 재실행 여부 판단

### 5. 예외처리 클래스 util.inputCheck
- 올바른 3자리 수를 입력을 받는지 확인하는 checkGameNumber()
- 재실행 여부 입력을 확인하는 checkOptionNumber()
- 입력받은 숫자가 올바른 범위인지 확인하는 checkNumberBound()

<br>

### 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
