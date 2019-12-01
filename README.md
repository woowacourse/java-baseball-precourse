# Precourse Week 1 - 숫자 야구 게임


## 미션 요구사항

>### 기능 요구사항
>
> 1. 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
> 
> 2. 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌드를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
>       * [예시] 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1 스트라이크, 456을 제시한 경우 : 1 스트라이크 1볼, 789를 제시한 경우 : 낫싱
> 
> 3. 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
> 
> 4. 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
> 
> 5. 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

>### 프로그래밍 요구사항
>
> 1. 자바 코드 컨벤션을 지키면서 프로그래밍한다.
>       * [Google Java Style Guide 참고](https://google.github.io/styleguide/javaguide.html)
> 
>       * [자바 코딩 규칙(Java Code Conventions) 참고](https://myeonguni.tistory.com/1596)
> 
> 2. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
> 
> 3. 3항 연산자를 쓰지 않는다.
> 
> 4. 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
> 

<br>

## 구현해야 할 기능 목록 

1. (기능 3) **1부터 9까지 서로 다른 수**로 이루어진 **3자리의 수**를 생성하는 기능 - **구현 완료**.

   * (구현) 숫자 생성시 **0**이 포함되지 않도록 생성.

   * (구현) 각 자리의 수가 **서로 다른 3자리의 수** 생성 (이전 자리의 수와 비교 필요).

2. (기능 3) 사용자로부터 **3자리 수를 입력**받는 기능 - **구현 완료**.

   * (예외) **1부터 9까지의** 3자리 수가 입력되지 **않은** 경우 (문자 또는 3자리 미만, 초과의 경우, **0이 들어올 경우**).

   * (예외) 3자리 수 중에서 **같은 수가 입력**된 경우.

   * ~~(예외) **0**이 입력된 경우~~ - 첫번째 예외와 병합.
   
3. (기능 2) **스트라이크**의 개수를 구하는 기능 - **구현 완료**.

   * (구현) 생성된 수와 입력된 수 비교 후 **동일한 자리 - 동일한 수** 의 개수 측정.
   
4. (기능 2) **볼**의 개수를 구하는 기능.

   * (구현) 생성된 수와 입력된 수 비교 후 **서로 다른 자리 - 동일한 수** 의 개수 측정.
   
5. (기능 2) **포볼**(낫싱)인지 여부를 판단하는 기능.

   * (구현) 스트라이크의 개수와 볼의 **개수가 0**일 경우로 판단.
   
6. (기능 3) 스트라이크, 볼, 또는 포볼(낫싱)에 대한 결과를 **출력**.

   * (구현) 포볼(낫싱)일 경우를 출력.

   * (구현) 위 경우가 아닐 시 스트라이크와 볼의 개수를 출력.
   
7. (기능 4) 답과 일치하면 게임을 **종료**하는 기능.

   * (구현) **스트라이크의 개수가 3개**이면 답과 일치하므로 게임 종료.
   
8. (기능 5) 게임을 종료한 후 **다시 시작**하거나 완전히 **종료**하는 기능.

   * (구현) **1번**을 입력 받으면 게임을 **다시 시작** ([구현해야 할 기능](#구현해야-할-기능-목록)을 처음부터 다시 진행).

   * (구현) **2번**을 입력 받으면 게임(프로그램) **종료**.

   * (예외) **1또는 2가 아닌 입력**이 들어올 경우.

<br>

## 구현해야 할 기능 목록 - Class 설정

1. 전체 프로그램 실행을 위한 Main.

2. 게임의 전체적인 진행을 담당할 PlayBaseball.

   * 컴퓨터가 생성한 숫자를 저장.

   * 사용자가 입력한 숫자를 저장.

   * 스트라이크, 볼, 낫싱에 대한 결과를 저장.

   * 답과 일치하는지 여부를 판단.

   * 사용자의 입력을 저장한 후, 게임을 종료시키거나 다시 진행.

3. 사용자의 입력과 관련된 기능을 담당할 User - **구현 완료**.

   * 3자리 수를 받아오는 기능 구현.

   * 게임 종료 여부를 받아오는 기능 구현.

4. 컴퓨터의 숫자 생성 기능을 담당할 Computer - **구현 완료**.

   * 숫자를 생성하는 기능 구현.

5. 스트라이크. 볼, 낫싱을 판단하는 기능을 담당할 Referee.

   * 스트라이크의 개수를 측정하는 기능 구현.

   * 볼의 개수를 측정하는 기능 구현.

   * 스트라이크와 볼을 통한 낫싱 판단 기능 구현.


<br>

## 개발 진행 계획

1. 어떤 프로젝트인지와 구현해야 할 기능을 대략적으로 작성.

   * 과제에 진행에 필요한 내용들을 [README.md](./README.md)에서 모두 볼 수 있도록 작성.

2. [구현해야 할 기능 목록](#구현해야-할-기능-목록)에 대한 세부적인 추가 기능 및 예외 처리 목록 작성.

   * 구현 방법과 예외 처리에 대한 간략한 설명 및 계획 추가.

3. [구현해야 할 기능 목록](#구현해야-할-기능-목록) 순서대로 Class 생성 및 코드 작성 ([기능의 함수화](#프로그래밍-요구사항)).

   * 구현해야 할 기능에 따른 Class 설정.

   * 최대한 Code Conventions를 지키면서 작성 (Naming에도 신경쓰기).

4. 전체적인 리펙토링 ([기능의 함수화](#프로그래밍-요구사항) 확인, 상수 사용 확인, 코드의 중복 여부 확인).

5. [프로그래밍 요구사항](#프로그래밍-요구사항) 중 코드 부분을 중점적으로 확인 (indent depth와 3항 연산자).

6. [프로그래밍 요구사항](#프로그래밍-요구사항) 중 Convention을 중점적으로 확인.