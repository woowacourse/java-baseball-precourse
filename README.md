# 미션 - 숫자 야구 게임

## 2021 11 24 목표 계획

1. 전체 계획 설정. <- 11/25 완성

   1. 협력관계 구상하기 

      ![wooteco1](https://github.com/xi-jjun/xi-jjun.github.io/blob/master/_posts/study/img/wooteco1.png?raw=True)

   2. 각 기능별 개발 일정 만들기

2. 객체 협력 관계 구상. <- 11/27 완성

   1. 객체
      1. RandomGenerator <- 11/25 완성
         - 알맞은 랜덤 값을 발생시켜서 Computer에게 줘야할 책임이 있음.
      2. Player <- 11/27 완성
         - Console에서 받은 사용자입력을 player의 알맞은 형식으로 바꿔야할 책임이 있음.
         - 입력 받은 값을 Computer에게 줘야할 책임이 있음.
      3. Computer <- 11/25 완성
         - 랜덤 값 받아야 할 책임이 있음.
         - Player로 부터 받은 tryNumber에 대한 힌트를 제공할 책임이 있음.
   2. Controller
      1. GameHandler <- 11/27 완성
         - 게임을 시작하고 어떻게 진행해야할지 관리할 책임.
         - 사용자로부터 Console에서 받은 입력을 Player 객체에게 줘야할 책임.
         - Player 객체가 받은 값을 Computer에게 건내줘야할 책임.
         - Computer가 제공한 Hint를 사용자에게 보여줘야할 책임.
         - Computer 가 판단한 Hint 기준으로 정답인지 확인해줘야할 책임.
         - 사용자의 모든 Console 입력에 대해서 적절하지 않은 값에 대한 예외처리를 해야할 책임

3. Domain 설계 + 개발. (아래에서 더 자세히)

<br>

## Domain 개발

1. RandomGenerator <- 11/25 완성
   1. 싱글톤 패턴으로 구현. - `getInstance()` : RandomGenerator 객체 반환
   2. 난수 발생 - `generateRandomNumbers()` : 난수 3개 생성
   3. 정답 난수 재발생 - `reGenerate()`
   4. 생성된 난수가 적절한지 판단. - `checkDuplicateNumber()`
      1. 모두 다른 숫자가 되게 만들기. 
      2. 0이 없게 만들기.
   5. 정답 난수 만들기 - `generateRandomAnswer()`
   6. 정답을 전달하기 위한 getter - `getAnswer()` : 정답 난수 반환
2. Computer
   1. 싱글톤 패턴으로 구현 - `getInstance()` : Computer 객체 반환. 반환할 때마다 RandomGenerator의 난수 재생성
   2. Player에게 힌트를 알려줘야 함 - `generateHint()` : Player로 부터 받은 tryNumber를 기반으로 힌트 제공
      1. Ball 개수 카운트 - `countBall()` 
      2. Strike 개수 카운트 - `countStrike()`
3. Player
   1. 싱글톤 패턴으로 구현 - `getInstance()` : 해당 Player 객체 반환
   2. `Console.readLine()`에 의해 들어오는 String type 사용자 입력을 알맞은 형식으로 변환 - `playerInput()`
      - String type → int[] type
      - tryNumber 라 명명하고 해당 배열에 저장
   3. tryNumber를 Computer에게 전달하기 위한 getter - `submitTryNumber()` : tryNumber 배열 반환

<br>

## 2021 11 27 목표 계획

1. Controller 개발. 기능 정리 <- OK
   1. 게임을 진행시켜줘야 함
   2. 사용자의 입력을 Console에서 받아서 Player 에게 넘겨줘야 함
   3. Player 의 tryNumber 를 Computer 에게 넘겨줘야 함
   4. Computer 가 제공하는 힌트를 사용자에게 Console에서 보여줘야 함
   5. 사용자의 적절하지 못한 입력에 대해 판별 후, 예외처리를 해줘야 함
   6. 정답인지 판단하고 게임을 재시작 할지 사용자에게 물어봐야 함
2. Application 완성 <- OK
   1. 게임을 시작시켜야 함

<br>

## GameHandler 개발

1. 게임을 진행시켜줘야 함 - `start()` : 안에 while loop로 게임을 지속시킴.
2. 게임을 진행시킬 한 단위의 프로세스 - `playing()` 
3. 사용자의 입력을 받는 method - `getPlayerInput()` : `Console.readLine()` 으로 사용자의 입력을 받아 반환
4. 사용자의 입력이 적절한지 판단 - `checkValidInput() ` : 사용자의 입력이 적절한지 판단. 적절하지 못하면 `IllegalArgumentException` 발생
5. Computer가 제공하는 힌트를 사용자에게 보여줘야 함 - `showHint()` : Console에 힌트를 출력
6. 재시작을 할 것인지 사용자에게 물어봐야 함 - `isRestart()` : restart 한다면 1 반환. 아니면 2 반환

<br>

## Application 개발

`GameHandler` 의 `start()` method를 무한루프로 실행.

