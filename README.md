
# Baseball Game 
---
### 기능 요구사항
###### baseball game 으로 다음과 같은 규칙을 따르는 게임을 실행한다.
1. 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
1. 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
ex)상대방(컴퓨터)의 수가 425 일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1스트라이크 1볼, 789를 제시한 경우 : 낫싱
1. 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1 에서 9까지 서로 다른 임의의 수3 개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는3 개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
1. 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
1. 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
---
### 구성
- Main.java
- InputNumbers.java
- RandomNumbers.java
- PlayinGame.java
    * public void start()
    * private void gameSet()
    * private void play()
    * private void count(int i , int j)
    * private void printCount()
    * private void continueCheak()

---
### 설명
##### Main.java
Main class로 프로그램을 실행한다. 
이 클레스는  baseball game 실행을 위한 클래스 이다.
playingGame class를 생성해  start 매서드를 실행하면 게임이 시작된다.


##### InputNumbers.java
InputNumbers class로 3개의 서로 다른 수를 입력받기위하나 클래스이다.
클래스 생성과 동시에 연속된 1~9 사이의 서로 다른 자연수를 입력받아 배열에 저장한다.

##### RandomNumbers.java
RandomNumbers class로 3개의 서로 다른 한자리 자연수를 생성하기 위한 클래스이다.
클래스 생성과 동시에  1~9 사이의 서로 다른 자연수를 생성하여 배열에 저장한다.


##### PlayinGame.java
이 클래스는 baseball 게임을 실행하는 클래스이다.
 start() 메서드를 실행하면 게임이 시작된다.
 
    * public void start()
    게임일 실행하는 매서드.
    
    * private void gameSet()
     RandomNumbers class 를 생성해 3개의 랜덤한 1자리 자연수를 생성한다.
     
    * private void play()
    InputNumbers() class 를 사용해 3개의 1자리 자연수를 입력받으면 count() 매서드를 사용해 볼카운트를 센다.
    
    * private void count(int i , int j)
    볼카운트를 세는 매서드
    
    * private void printCount()
    볼카운트를 출력하는 매서드
    
    * private void continueCheak()
    한 게임이 종료되면 게임을 계속할지 종료할지 묻는 매서드.
---
### 버그들 (Known Bugs)

---
### 프로그래머
 권경동 (fancyartisan@gmail.com / rudehd10@naver.com)

---
### 체인지로그




