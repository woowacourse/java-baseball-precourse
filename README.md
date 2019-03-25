## 클래스
- BaseBall : 야구게임의 기본 원칙과 로직을 담는다.
- PlayBall : 야구게임의 in-out을 담당한다. 사용자와 상호작용하며 흐름을 제어한다.
- Score    : 야구게임의 결과를 담는다.
- Main     : PlayBall을 실행한다.

## 메소드
#### 1. BaseBall
- getRandomNumber   : 랜덤으로 생성한 3자리 숫자를 얻는다.
- getGameNumber     : 게임에 사용할 수 있는 3자리 숫자를 얻는다.  

- hasZero           : 문자에 "0"이 포함되어 있는지 확인한다.
- isDuplicated      : 문자에 중복 요소가 있는지 확인한다.

- isDigit           : 문자를 숫자로 캐스팅할 수 있는지 확인한다.
- isInRange         : 문자열 길이가 3인지 확인한다.
- isValid           : 야구게임에 유효한 문자인지 확인한다.

- getReferee        : 게임의 결과를 Score타입으로 리턴한다.  

#### 2. PlayBall
- playGame          : 게임을 시작한다.
- playOneGame       : 야구게임 1회를 시작한다.  

- getInputConsole   : 콘솔 입력을 가져온다.  
- printInvalidArgMessage : 유효한 입력이 아님을 콘솔에 출력한다.

- printVictory      : 승리 메시지를 콘솔에 출력한다.
- wantContinue      : 게임을 계속할 것인지 확인한다.

#### 3. Score
- getStrike         : 스트라이크 갯수를 얻는다.
- getScore          : 게임 결과를 문자열로 얻는다.

#### 4. Main
- main              : PlayBall 인스턴스를 생성하고 playGame을 실행한다.

