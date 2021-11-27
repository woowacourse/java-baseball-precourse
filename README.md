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

3. Domain 설계 + 개발. <- 11/27 완성

<br>

## Domain 개발

1. RandomGenerator
   1. 기능
      1. 난수 발생 - `generateRandomNumbers()` : 난수 3개 생성
      2. 게임을 다시 시작할 때 난수 재발생 - `reGenerate()`
      3. 생성된 난수가 적절한지 판단. - `checkDuplicateNumber()`
         1. 모두 다른 숫자가 되게 만들기. 
         2. 0이 없게 만들기.
      4. 정답 만들기 - `generateRandomAnswer()`

<br>

## 2021 11 27 목표 계획

1. Controller 개발 <- OK
2. Application 완성 <- OK

