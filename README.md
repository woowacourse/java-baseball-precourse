# 1주차 미션 - 숫자 야구 게임

## 기능 요구사항
* 기본적으로1부터9까지서로다른수로이루어진3자리의수를맞추는게임이다.
* 같은수가같은자리에있으면스트라이크,다른자리에있으면볼,같은수가전혀없으면포볼또는낫싱이란힌트를
얻고,그힌트를이용해서먼저상대방(컴퓨터)의수를맞추면승리한다.
  * [예]상대방(컴퓨터)의수가425일때,123을제시한경우:1스트라이크,456을제시한경우:1스트라이크1볼,
789를제시한경우:낫싱
* 위숫자야구게임에서상대방의역할을컴퓨터가한다.컴퓨터는1에서9까지서로다른임의의수3개를선택한다.게
임플레이어는컴퓨터가생각하고있는3개의숫자를입력하고,컴퓨터는입력한숫자에대한결과를출력한다.
* 이같은과정을반복해컴퓨터가선택한3개의숫자를모두맞히면게임이종료된다.
* 게임을종료한후게임을다시시작하거나완전히종료할수있다.

## 프로그래밍 요구사항
* 자바코드컨벤션을지키면서프로그래밍한다.
  * 참고문서:https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* indent(인덴트,들여쓰기) depth를 3이 넘지않도록구현한다.2까지만허용한다.
  * 예를들어 while문안에 if문이있으면 들여쓰기는2이다.
  * 힌트:indent(인덴트,들여쓰기) depth를 줄이는 좋은방법은함수(또는메소드)를분리하면된다.
* 함수(또는 메소드)가한가지일만하도록최대한작게만들어라

## 프로그램 기능 목록
* 참고자료 : http://woowabros.github.io/study/2016/07/07/think_object_oriented.html
##### class Game
* Game 클래스는 질문자와, 답변자의 게임을 진행하고 점수를 매긴다.

* 속성
  * private :: Questioner questioner : 질문자 객체
  * private :: Answerer answerer : 답변자 객체
* 생성자
  * questioner, answerer 객체를 입력받아 초기화 한다.
* 메소드
  * public :: play() : 질문자의 문제와 답변자의 정답을 비교하고, 답변자의 점수를 매긴다.
    * private :: checkStrike() : 같은 숫자가 같은 자리에 있으면 스트라이크
    * private :: checkBall() : 같은 숫자가 다른 자리에 있으면 볼
  * public :: getQuestioner() : 질문자를 반환한다.
  * public :: getAnswerer() : 답변자를 반환한다.
  
##### class Questioner
* Questioner 클래스는 숫자야구게임의 문제를 내는 컴퓨터이다.

* 속성
  * private :: int[] number : 서로 다른 3 자리 수
* 생성자
  * number 를 길이가 3인 배열로 초기화 한다.
* 메소드
  * public :: setNumber() : 서로 다른 3자리 수를 만든다.
    * private :: checkReduplicate() : 서로 다른 수를 만들기 위해 중복된 수가 있는지 확인 한다.
  * public :: getNumber() : number 를 반환한다.
  
##### class Answerer
* Answerer 클래스는 숫자야구게임의 문제를 맞추는 사람이다.

* 속성
  * private :: int[] number : 답변자가 제출한 3자리 수
  * private :: Score score : 게임을 통한 점수 결과
* 생성자
  * number 를 길이가 3인 배열로 초기화 한다.
  * score 를 null 로 초기화 한다.(아직 게임결과 점수가 없다.)
* 메소드
  * public :: setNumber() : 3자리 문자열을 입력 받아 3자리 정수형 배열에 담는다.
  * public :: getNumber() : number 를 반환한다.
  * public :: setScore() : 새로운 점수를 입력 받는다.
  * public :: getScore() : 점수를 반환한다.

##### class Score
* Score 클래스는 숫자야구게임 결과를 담는다.

* 속성
  * private :: int strike : 스트라이크의 개수
  * private :: int ball : 볼의 개수
* 생성자
  * 스트라이크와 볼의 개수를 0 으로 초기화 한다.  
* 메소드
  * public :: getStrike() : 스트라이크의 개수를 반환한다.
  * public :: setStrike() : 스트라이크의 개수를 변경한다.
  * public :: getBall() : 볼의 개수를 반환한다.
  * public :: setBall() : 볼의 개수를 변경한다.
  * public :: isNothing() : 낫싱 유무를 확인한고 결과를 반환한다.
  * public :: isCorrect() : 정답 유무를 확인하고 결과를 반환한다.
  
### class GameUI
* GameUI 클래스는 숫자야구게임 진행을 위한 사용자 인터페이스다.

* 메소드
  * public :: main() : 숫자야구게임 프로그램을 시작 후 질문자와 답변자의 객체를 생성한다.
    * private :: run() : 질문자와 답변자가 참여한 숫자 야구게임이 시작 된다.
    * private :: askNumber() : 답변자(사용자)에게 정답을 요구한다.
    * private :: askRestart() : 답변자(사용자)에게 숫자야구게임 재시작을 묻는다.
    * private :: printScore() : 답변자(사용자)에게 게임 결과를 보여준다.
    * private :: checkGameEnd() : 게임을 종료(모두 맞음)할 수 있는지 확인한다.