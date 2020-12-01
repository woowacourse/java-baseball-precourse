# 미션 - 숫자 야구 게임

> 우아한테크코스 : 프리코스 1주차 미션 '숫자 야구 게임'을 구현한 프로젝트입니다.

세부 프로그래밍 요구사항은 [java-baseball-precourse](https://github.com/woowacourse/java-baseball-precourse) 저장소의 README 파일을 준수했습니다.

<br>

## 구현 기능 목록

1. 프로그램이 1에서 9까지의 서로 다른 임의의 수 3개를 자동으로 선정하도록 한다.
    * 이미 구현되어 있는 RandomUtils 클래스를 통해 숫자를 랜덤 선택한다.
    * 순차적으로 생성되는 숫자가 이전의 번호들과 중복이 되는지 체크한다.
        * 만약 중복이라면 해당 자리의 숫자를 다시 랜덤 선택한다.

2. 사용자로부터 3자리 숫자를 입력받는다.
    * 입력 안내 메시지를 출력한다.
    * 사용자가 입력한 숫자가 1에서 9까지의 서로 다른 임의의 수 3개인지 확인한다.
        * 다음 비정상적인 사용자 입력값에 대해 IllegalArgumentException을 발생시킨다.
            * 3자리 숫자가 아닌 경우.
            * 3자리 숫자들에 중복이 있는 경우.
            * 3자리 숫자들에 0이 포함된 경우.
    * 요구사항에는 별도의 명시 사항은 없으나, 예외가 발생하면 View에서 에러 메시지를 출력하고 다시 재입력을 받는다.

3. 프로그램이 선정한 숫자와 사용자의 입력 숫자를 비교한다.
    * 같은 자리에 같은 숫자가 있는 경우 스트라이크로 인식한다.
    * 다른 자리에 같은 숫자가 있는 경우 볼로 인식한다.
    * 스트라이크와 볼의 개수를 카운팅한다.

4. 사용자의 입력 숫자에 대한 결과를 볼, 스트라이크 갯수로 반환한다.
    * 해당 결과(힌트) 메시지를 다음과 같이 출력한다.
        * 볼과 스트라이크가 모두 존재하는 경우 : "x볼 y스트라이크"
        * 볼만 존재하는 경우 : "x볼"
        * 스트라이크만 존재하는 경우 : "x스트라이크"
        * 볼과 스트라이크가 모두 존재하지 않는 경우 : "낫싱"

5. 프로그램이 게임의 진행 및 종료 조건 상태를 판단하도록 한다.
    * 3스트라이크를 맞추지 못한 경우, **2번** 으로 돌아가 다시 사용자로부터 입력값을 받으며 게임을 계속 진행한다.
    * 3스트라이크를 맞춘 경우, **게임 재시작/종료**에 대한 안내 메시지를 출력한다.
        * 사용자로부터 게임 재시작/종료에 대한 입력값을 받는다.
            * 1을 입력 받으면, **1번** 으로 돌아가 숫자 야구 게임을 처음부터 재시작한다.
            * 2를 입력 받으면, 프로그램이 종료된다.
        * 이 때, 1과 2를 제외한 문자를 입력받는 경우 IllegalArgumentException을 발생시킨다.
        * 요구사항에는 별도의 명시 사항은 없으나, 예외가 발생하면 View에서 에러 메시지를 출력하고 다시 재입력을 받는다.

* 발생 가능한 모든 입력 예외 케이스는 View에서 IllegalArgumentException으로 처리하고, Domain에서는 예외 검증 및 호출 시 사용자 정의 예외를 사용해본다.

<br>

## 프로젝트를 진행하면서 고민한 내용들

미션을 진행하면서 고민했던 내용들을 개인적으로 공부해보고 [블로그](https://xlffm3.github.io/java/etc/Woowacourse_precourse_baseball/) 에 정리해보았습니다.

1. 객체의 책임과 역할 : 스트라이크 및 볼 계산
    * 볼들의 리스트를 가지고 있는 객체(BaseballNumbers)가 인덱스를 순회하며 계산하는 것이 가장 쉽다.
    * 별도의 객체(ScoreChecker)가 계산 규칙을 가지고 중간에서 계산을 개입하는 것은 어떨까?
2. 객체의 책임과 역할 : View 입력 예외 처리
    * 입력 예외를 어느 시점 및 어디에서 검사하고 IllegalArgumentException을 호출해야 하는가?
        * View or Domain?
        * View에서 입력 예외를 처리하는 로직이 Domain 내부 로직을 과도하게 관여 및 침범하는게 아닌가?
    * 입력 예외가 발생하면 단순히 예외를 호출하는 것으로 충분한가?
        * View에서 try-catch를 통해 예외를 처리하고, 올바른 값을 다시 재입력받도록 코드를 짜야하는가?
    * 발생 가능한 모든 입력 예외 케이스를 View에서 try-catch로 완벽하게 처리했다면,
        * 입력값을 활용하는 Domain의 비즈니스 로직에서 발생 가능한 예외는 try-catch로 처리하지 않아도 되는가?
    * 입력 예외를 다룰 때, try-catch recursion vs while?
3. equals를 꼭 오버라이드해야 할까?
4. 구현 기능 목록을 어느정도로 상세하게 작성해야 할까?
5. 커밋 메시지는 영어 혹은 한글?
6. 테스트 메서드의 이름은 영어 혹은 한글?
7. 정적 팩토리 메소드 생성 기준?

<br>

## 최종 패키지 및 클래스 구성

> AssertJ를 사용하여 테스트 코드를 작성했습니다.

* baseball 패키지
    * domain 패키지
        * game 패키지
            * BaseballGameMachine
            * GameResult
            * GameState
        * number 패키지
            * BaseballNumber
            * BaseballNumbers
        * exception 패키지
            * BaseballNumberCountsException
            * BaseballNumberRangeException
            * CannotFindGameStateException
            * CannotPlayException
            * InvalidGameResultException
    * view 패키지
        * InputView
        * OutputView
    * Application

* utils 패키지
    * RandomUtils

* test code
    
<br>

---
