# BallsResult 클래스
## 3개 공에 대한 판정 결과를 관리하는 클래스

### <code>public</code>
#### enum BallResult{};
> NONE, BALL, STRIKE 상수를 가지는 열거형으로, 
> 1개 공에 대한 판정 결과를 나타냄

#### void addBallResult(BallResult one);
> 판정결과 1개를 추가하는 메소드

#### boolean printResults();
> 종합 판정결과(낫싱, 스트라이크/볼, 정답)를 출력하고, 3 스트라이크일 경우 true를 반환하는 메소드

### <code>private</code>
#### int ballScore;
> '볼'로 판정된 횟수

#### int strikeScore;
> '스트라이크'로 판정된 횟수

#### boolean isCorrect();
> 3 스트라이크 여부를 반환하는 메소드

#### boolean isNothing();
> 0 볼 0 스트라이크 여부를 반환하는 메소드 

#### void printScore();
> '스트라이크' 점수와 '볼' 점수를 출력하는 메소드

> <code>1볼</code>
> <br><code>2 스트라이크</code>
> <br><code>1 스트라이크 2볼</code>

# BaseBall 클래스
## 숫자야구 게임을 진행하는 클래스

### <code>public</code>

#### void Run();
> 숫자 야구 한 게임을 진행하는 메소드

#### String getLine();
 > 사용자의 입력 한 줄을 입력받아 반환하는 메소드

### <code>private</code>

#### Integer getRandomInteger(int min, int max)
> min~max 범위 안의 무작위 정수값을 반환하는 메소드

#### ArrayList&lt;Integer&gt; stringToArrayList(String ballsString);
> "345"를 [3, 4, 5]로 변환하여 반환하는 메소드

#### final int BALLS = 3;
> 공 개수를 뜻하는 심볼릭 상수
    
#### ArrayList&lt;Integer&gt; initializeBallRange();
> [1, 2, 3, 4, 5, 6, 7, 8, 9]를 반환하는 메소드

#### Integer getRandomBall(ArrayList&lt;Integer&gt; range);
> range 안의 무작위 Ball 하나를 반환하는 메소드 

#### ArrayList&lt;Integer&gt; getRandomBalls();
> 중복되지 않는 무작위 Ball 3개를 반환하는 메소드

#### BallResult evaluateBall(int ball, int order, ArrayList&lt;Integer&gt; answer);
> 하나의 Ball의 판정 결과를 반환하는 메소드

#### BallsResult evaluateBalls(ArrayList&lt;Integer&gt; guess, ArrayList&lt;Integer&gt; answer);
> 3개의 Ball에 대한 판정 결과를 반환하는 메소드