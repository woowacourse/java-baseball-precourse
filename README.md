# 프리코스 1주차 미션 : 숫자 야구 게임
- - -
## 기능 요구사항
- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크,다른자리에있으면볼,같은수가전혀없으면포볼또는낫싱이란힌트 얻고,그힌트를이용해서먼저상대방(컴퓨터)의수를맞추면승리한다.
- [예] 상대방(컴퓨터) 의수가 425일 때,123을제시한경우:1스트라이크,456을제시한경우:1스트라이크1볼, 789를 제시한 경우:낫싱
- 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다.컴퓨터는1에서9까지서로다른임의의수3개를선택한다.게임플레이어는컴퓨터가생각하고있는3개의숫자를입력하고,컴퓨터는입력한숫자에대한결과를출력한다.
- 이런 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후계임을 다시 시작하거나 완전히 종료할 수 있다.

## 구현 기능 목록
1. 게임을 실행하고,입력읕 통해 반복 가능하게 하는 기능(Shell)
2. 한 라운드의 게임을 실행하는 기능(playGame)
3. 컴퓨터가 방어할 숫자 배열을 만드는 기능(defenseArr)
- 1~9 사이의 랜덤한 3개의 숫자 배열을 리턴
4. 플레이어의  입력으로 부터 공격 숫자 배열을 리턴하는 기능(attackArr)
- 올바른지 판별하여 올바르게 입력 될 때까지 반복해서 입력을 받아야 한다.
5. 방어 배열과 공격 배열로 부터 공격 결과를 리턴,출력하는 기능 (attackResult, 깊이 제한 때문에 여러 메소드로 나눔)
- 해당 숫자가 방어 배열에 있는지 체크(isHitable)
- 스트라이크 갯수를 리턴(countStrike)