# 우아한 테크코스 프리코스 1주

> 숫자 야구 게임

## 기능 요구사항

- 기본적으로1부터9까지서로다른수로이루어진3자리의수를맞추는게임이다.
- 같은수가같은자리에있으면스트라이크,다른자리에있으면볼,같은수가전혀없으면포볼또는낫싱이란힌트를 얻고,그힌트를이용해서먼저상대방(컴퓨터)의수를맞추면승리한다.
  - [예]상대방(컴퓨터)의수가425일때,123을제시한경우:1스트라이크,456을제시한경우:1스트라이크1볼, 789를제시한경우:낫싱
- 위숫자야구게임에서상대방의역할을컴퓨터가한다.컴퓨터는1에서9까지서로다른임의의수3개를선택한다.게임플레이어는컴퓨터가생각하고있는3개의숫자를입력하고,컴퓨터는입력한숫자에대한결과를출력한다.
- 이같은과정을반복해컴퓨터가선택한3개의숫자를모두맞히면게임이종료된다.
- 게임을종료한후게임을다시시작하거나완전히종료할수있다.

## 기능 구현

1. Game를 실행시킬 Main함수 구현
2. Game이 실행되면 숫자 3개 셋팅 함수 구현