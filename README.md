# 우아한테크코스 프리코스 과정 1주차 (19.11.27 ~ 12.03)
  # Baseball Game !
  ### 문제설명
  ##### • 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
  ##### • 같은 수가 같은 자리에 있으면 스트라이크, 다른자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
  ##### • [예] 상대방(컴퓨터)의 수가 425일때, 123을 제시한 경우: 1스트라이크, 456을 제시한 경우: 1스트라이크 1볼, 789를 제시한 경우: 낫싱
  ##### • 위 숫자야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
  ##### • 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
  ##### • 게임을 종료한 후, 게임을 다시 시작하거나 완전히 종료할 수 있다.  
  
## 사용할 기능 미리 정의

```
int[] initBaseballNumber(int answerNumberA, int answerNumberB, int answerNumberC)
```
##### 정답이 되는 숫자들을 랜덤으로 선택하여 주는 메소드이다.
##### 매번 실행될 때마다 새로운 랜덤 숫자들을 초기화 시켜준다.

```
boolean isOverlap(int[] answerNum)
```
##### 생성된 정답 숫자열이 서로 중복되었다면 TRUE 를 반환하는 메소드이다.

```
int isStrike(int[] answerNum, int[] num)
int isBall(int[] answerNum, int[] num)
```
##### 정답 숫자 배열과 사용자가 입력한 숫자 배열을 인자로 넣으면, STRIKE 인 횟수를 반환해주는 메소드와,
##### 정답 숫자 배열과 사용자가 입력한 숫자 배열을 인자로 넣으면, BALL 인 횟수를 반환하는 메소드이다.

```
boolean isSame(int answerNumber, int number)
```
##### 인자로 들어온 두 수가 같으면 TRUE 를 반환한다.
##### 정답 숫자 A,B,C 중 하나와 사용자가 입력한 숫자 A,B,C 중 하나를 인자로 받아서 그 두 수가 같은지를 판별하기 위해 만든 메소드이다. 

```
int[] splitNumbers(int[] UserNumber, int number)
```
##### Int 형 인자를 넣으면 각 자리수가 분리된 (같이 인자로 넣어졌던) int 형 배열을 출력해주는 메소드이다.

```
int squre(int root, int squareNumber)
```
##### Int 형 인자 root 를 squareNumber 만큼 제곱해주는 메소드이다. root^squareNumber 를 반환한다.

```
boolean isZero(int number)
```
##### 해당 숫자가 0이면 TRUE 를 반환하는 메소드

```
boolean printResult(int isStrike, int isBall)
```
##### STRIKE 횟수와 BALL 횟수를 넣으면 추측에 대한 결과 프린트해주는 메소드이다.
##### * 메인 메소드에서는 이 메소드를 while 문으로 반복하여 돌려준다. 정답을 맞출때까지! (메소드가 TRUE를 반환할 때까지!)

```
void println(String output)
```
##### String 형 인자를 넣으면 출력해주는 메소드이다.