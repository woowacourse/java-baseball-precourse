숫자야구
========
기능 요구
--------
* 기본적으로 1부터9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고,그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
* [예]상대방(컴퓨터)의 수가
    * 425일때,123을제시한경우:1스트라이크
    * 456을제시한경우:1스트라이크1볼
    * 789를제시한경우:낫싱
* 위 숫자야구게임에서 상대방의 역할을 컴퓨터가 한다.컴퓨터는 1에서9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

버전 프리뷰
--------------
### Version 1.0.0
* 기능 요구에 충실한 버전입니다.

### Version 1.1.0
* 기존의 Single타입의 게임 외에 Multi타입의 게임을 추가하였습니다.
* 기존의 Single타입이 컴퓨터의 수를 유저가 혼자 맞추는 게임이었다면, Multi타입은 유저가 컴퓨터와 경쟁을 하게 됩니다.
* 컴퓨터는 자신의 답과 결과 값을 학습하여 정답에 가까운 값을 규칙을 통해 얻습니다.
* 먼저 서로의 문제를 맞추는 플레이어가 승리하게 됩니다.
기능 프리뷰
--------------

Version 1.1.0
##New Class

### Class Brain
* 뇌 - 컴퓨터가 정답을 맞추기 위한 학습을 도움
   * Inheritance : Computer
   * Class :
   * Method :
         * ArrayList[] getLearningData -> 학습데이터를 수집함.
         * int[] getData -> 학습데이터를 바탕으로 얻은 정답을 배열로 리턴
   * Variable :
         * ArrayList []info -> 학습데이터를 담을 변수

##Update Class
### Class Index
* 앱의 전체적인 시작과 종료를 담당
    * Class : Index
    * Method :
         * void singleStart() -> 컴퓨터의 답을 혼자서 맞추는 singleVersion 시작
         * void MultiStart() -> 컴퓨터와 유저가 서로 각자의 답을 맞추는 MultiVersion 시작
         * void end() -> 게임을 종료하는 메소드
    * Variable :
         * String endCommend -> end()를 시킬 명령어

### Class Stage
* 게임이 진행되는 클래스
    * Class : Index, Stage
    * Method :
         * void singlePlay() -> singleVersion 전체 동작
         * void MultiPlay() -> MultiVersion 전체 동작
         * int[] check() -> 답을 확인하고 스트라이크 볼의 갯수를 리턴하는 함수
         * String checkLog()-> check에서 리턴한 값을 문자열로 정리해 리턴

## Class User
* 유저
    * Inheritance : Config
    * Class :
    * Method :
         * int[] receiveNum() -> 사용자에게 서로 다른 1~9까지의 정답 3개를 입력받음
         * (Config)int[] makeNumArray() -> receiveNum()의 리턴값을 배열로 리턴
    * Variable :
         * int[] answer -> makeNumArray()의 리턴값을 가질 변수 // 정답을 시도


## Class Computer
* 컴퓨터
    * Inheritance : Config
    * Class :
    * Method :
         * int[] makeRandomNum() -> 1~9까지의 서로 다른 수 3개를 배열에 담아 리턴한다.
         * (Config)int[] makeNumArray() -> receiveNum()의 리턴값을 배열로 리턴
         * void printComNum() -> 컴퓨터의 입력값을 출력합니다.
         * int[] learnedData() -> Brain에서 학습하고 그 결과를 배열로 리턴한다.
    * Variable :
         * int[] problem -> makeNumArray()의 리턴값을 가질 변수 // 문제 생성

## Class Config
* 도구 - 다른 클래스에서 사용하는 공통적인 메소드와 변수를 담음
    * Class :
    * Method :
         * int[] makeNumArray() -> receiveNum()의 리턴값을 배열로 리턴
         * Boolean choosePre() -> 선공 후공을 참,거짓으로 리턴합니다.
    * Variable :

## Class Referee
* 심판 - Stage 클래스의 check메소드를 도와 스트라이크와 볼에 대한 판단
    * Class :
    * Method :
         * int countStrike() -> receiveNum()의 리턴값을 배열로 리턴
         * int countBall() -> receiveNum()의 리턴값을 배열로 리턴
         * int indexOf() -> receiveNum()의 리턴값을 배열로 리턴
    * Variable :

------------------------------------------------------------------------------------------------

Version 1.0.0
### Class indi.moon.firstweek.Indexface.Index
* 앱의 전체적인 시작과 종료를 담당
    * Class : Index
    * Method :
         * void start() -> 게임을 시작하는 메소드
         * void end() -> 게임을 종료하는 메소드
    * Variable :
         * String endCommend -> end()를 시킬 명령어

### Class Stage
* 게임이 진행되는 클래스
    * Class : Index, Stage
    * Method :
         * void play() -> 게임의 전체 동작
         * int[] check() -> 답을 확인하고 스트라이크 볼의 갯수를 리턴하는 함수
         * String checkLog()-> check에서 리턴한 값을 문자열로 정리해 리턴

### Class User
* 유저
    * Inheritance : Config
    * Class :
    * Method :
         * int[] receiveNum() -> 사용자에게 서로 다른 1~9까지의 정답 3개를 입력받음
         * (Config)int[] makeNumArray() -> receiveNum()의 리턴값을 배열로 리턴
    * Variable :
         * int[] answer -> makeNumArray()의 리턴값을 가질 변수 // 정답을 시도


### Class Computer
* 컴퓨터
    * Inheritance : Config
    * Class :
    * Method :
         * int[] makeRandomNum() -> 1~9까지의 서로 다른 수 3개를 배열에 담아 리턴한다.
         * (Config)int[] makeNumArray() -> receiveNum()의 리턴값을 배열로 리턴
    * Variable :
         * int[] problem -> makeNumArray()의 리턴값을 가질 변수 // 문제 생성

### Class Config
* 도구 - 다른 클래스에서 사용하는 공통적인 메소드와 변수를 담음
    * Class :
    * Method :
         * int[] makeNumArray() -> receiveNum()의 리턴값을 배열로 리턴
    * Variable :

### Class Referee
* 심판 - Stage 클래스의 check메소드를 도와 스트라이크와 볼에 대한 판단
    * Class :
    * Method :
         * int countStrike() -> receiveNum()의 리턴값을 배열로 리턴
         * int countBall() -> receiveNum()의 리턴값을 배열로 리턴
         * int indexOf() -> receiveNum()의 리턴값을 배열로 리턴
    * Variable :


기능 단위 Commit 체크(Version 1.1.0)
------------------------------------------
- [ ] 버전에 따른 시작 구현
- [ ] 학습 데이터 수집
- [ ] 학습 데이터에 따른 결과값
- [ ] 선공 후공 구현
- [ ] 승리 혹은 패배 구현
- [ ] MultiVersion 완성

기능 단위 Commit 체크(Version 1.0.0)
------------------------------------------
- [ x] 인터페이스 구현하기
- [ x] 시작 종료
- [ x] 랜덤 문제 생성
- [ x] 정답 시도
- [ x] 정답 비교
- [ x] 문제에 대한 정답 결과 출력
- [ x] 정답 시 재시작
- [ x] 정답 시 게임 종료

