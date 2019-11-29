#1. 숫자 야구 게임
- 컴퓨터가 랜덤으로 생성한 1부터 9까지의 서로 다른 3개의 숫자를 맞추는 게임

## 프로그래밍 요구사항
1. 자바 코드 컨벤션을 지키면서 프로그래밍한다.
2. indent(들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지 허용함.
3. 3항 연산자를 사용하지 않는다.
4. 함수(메소드)는 한 가지 일만 하도록 최대한 작게 만든다.

## 구현해야 할 기능들
1. 컴퓨터의 랜덤 숫자 3개를 1부터 9까지 중복이 없도록 생성한다.
2. 사용자의 예측 숫자를 입력받는다.
	- 중복되는 숫자가 입력된 경우 다시 입력받는다. 예) 1 1 3
	- 범위 밖의 숫자가 입력된 경우 다시 입력받는다. 예) -1 0 19
	- 3개의 숫자가 아닌 경우 다시 입력받는다. 예) 1356, 12
3. 사용자가 예상한 숫자와 컴퓨터가 생성한 랜덤 숫자를 비교하여 결과를 출력한다.
	- 같은 수가 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱
4. 이 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
5. 게임을 종료한 후, 게임을 다시 시작하거나 완전히 종료할 수 있다.
	- 1번을 누를 시 게임 재시작, 2번을 누를 시 게임을 완전히 종료한다.