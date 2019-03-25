# 숫자야구 게임 (Java)
---
## 구현 목록
- BaseballGame (Class)
	- runProgram() : main program 실행 (게임 반복 여부)
	- runBaseball() : baseball game 실행
	- isValid() : 사용 가능한 입력값인지 확인
	- printHint() : 힌트(strike, ball 개수) 출력
	- setRandomNumber() : 3자리의 
- BaseballNumber (Class)
	- getter, setter
	- compareTo() : 객체 생성시 만들어진 난수를 사용하여 비교

### 기능 요구사항
- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
- [예] 상대방(컴퓨터)의 수가 425일 때,123을 제시한 경우: 1스트라이크, 456을 제시한경우: 1스트라이크 1볼, 789를 제시한 경우: 낫싱
- 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다.컴퓨터는1에서9까지서로다른임의의수3개를선택한다.<br>
플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에대한 결과를 출력한다.
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
