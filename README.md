#필요 기능 구현 목록
1. genRandomNum (중복없는 1 ~ 9)
2. receiveInput (입력 받기, input이 문제 없는지 확인(ex. 4자리, 0입력))
3. printOutput (x strike, y ball 출력, 3 strike의 경우 함수 return을 다르게)
4. calcSB (strike, ball calculate)
5. initSB (strike, ball initialization)
6. checkRestart (1은 다시 시작, 2는 종료)

main에서는 
1. genRandomNum
2. initSB
3. receiveInput
4. calcSB
5. printOutput (그냥 경우 2로, 3 strike의 경우 7로)
6. checkRestart (1은 1로, 2는 return 0(종료문 출력 후 프로그램 종료))



#기능 요구 사항

•기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

•같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.

 •예) 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1 스트라이크, 456을 제시한 경우 : 1 스트라이크 1볼, 789를 제시한 경우 : 낫싱
 
•위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.

•이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.

•게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

#프로그래밍 요구 사항

•자바 코드 컨벤션을 지키면서 프로그래밍한다.

• 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596

• indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.

• 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.

• 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.

•함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.


#진행 요구 사항
•미션은 https://github.com/woowacourse/java-baseball 저장소를 fork/clone해 시작한다.

•기능을 구현하기 전에 java-baseball/README.md 파일에 구현할 기능 목록을 정리해 추가한다.

•git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

•프리코스 과제 제출 문서 절차를 따라 미션을 제출한다.
