기능 요구사항

1. 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

2. 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.\
  [예] 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1 스트라이크, 456을 제시한 경우 : 1 스트라이크 1볼, 789를 제시한 경우 : 낫싱

3. 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.

4. 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다. 

5. 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

프로그래밍 요구사항

1. 자바 코드 컨벤션을 지키면서 프로그래밍한다.
   
2. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
   예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.\
   힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
3. 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.

기능 목록

메인
1. 게임 진행 , 게임 종료 체크

유저 
1. 메세지 보내기
2. 메세지 받기

컴퓨터
1. 랜덤 숫자 생성
2. 유저 메세지 수신
3. 보낼 메세지 작성
4. 유저 숫자와 랜덤 숫자 비교(볼 , 스트라이크 체크)