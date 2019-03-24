# 숫자야구 게임 (Java)
---
## 구현 목록
-Class BaseballGame
	- runProgram()
	- runBaseball()
	- isValid()
	- printHint()
	- makeRandomNumber()

- Class BaseballNumber

### 기능 요구사항
- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크,다른자리에있으면볼,같은수가전혀없으면포볼또는낫싱이란힌트 얻고,그힌트를이용해서먼저상대방(컴퓨터)의수를맞추면승리한다.
- [예] 상대방(컴퓨터) 의수가 425일 때,123을제시한경우:1스트라이크,456을제시한경우:1스트라이크1볼, 789를 제시한 경우:낫싱
- 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다.컴퓨터는1에서9까지서로다른임의의수3개를선택한다.게임플레이어는컴퓨터가생각하고있는3개의숫자를입력하고,컴퓨터는입력한숫자에대한결과를출력한다.
- 이런 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후계임을 다시 시작하거나 완전히 종료할 수 있다.

### 프로그래밍 요구사항
- 자바 코드 컨벤션
	- https://google.github.io/styleguide/javaguide.html
	- https://myeonguni.tistory.com/1596
- indent depth를 3이 넘지 않도록 구현한다. (2까지만 허용)
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게

### 참고
- 미션 저장소 : https://github.com/woowacourse/java-baseball
- 과제제출 : https://github.com/woowacourse/woowacourse-docs/tree/master/precourse