# 1주차 미션 - 숫자 야구 게임



## 미션 개요

1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다. 컴퓨터가 먼저 3자리의 수를 임의로 정하고, 게임 플레이어는 3자리의 수를 입력하여 컴퓨터가 정한 숫자를 맞추는 순서로 진행된다. 컴퓨터가 정한 숫자와 게임 플레이어가 입력한 숫자를 비교할 때, 다음과 같은 규칙을 따른다.

- 같은 숫자가 같은 자리에 있으면 스트라이크이다.
- 같은 숫자가 있지만 다른 자리에 있으면 볼이다.
- 같은 수가 전혀 없으면 포볼(혹은 낫싱)이다.

컴퓨터가 정한 3자리 수를 게임 플레이어가 맞추면(컴퓨터가 정한 3자리수와 게임 플레이어가 입력한 3자리 수가 동일하면), 게임 플레이어는 승리하고 게임은 종료된다.

컴퓨터가 정한 3자리 수를 게임 플레이어가 맞추지 못하면(컴퓨터가 정한 3자리수와 게임 플레이어가 입력한 3자리 수가 다르면), 컴퓨터는 게임 플레이어에게 힌트를 준다. 게임 플레이어는 힌트를 이용해 다시 컴퓨터의 숫자를 맞추려고 하고(3자리 숫자를 다시 입력하고), 이 과정을 승리할 때까지(모두 맞출 때까지) 반복한다.

게임 플레이어가 승리하여 게임이 종료되면, 게임 플레이어는 게임을 다시 시작하거나 완전히 종료한다.

## 핵심 개념

1. Baseball: 야구 게임을 의미하고, 게임을 진행하고 종료하는 기능을 한다.
2. Hitter: 타자를 의미하고, 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 임의로 정하는 기능을 한다.
3. Pitcher: 투수를 의미하고, 3자리의 수를 입력받아 타자가 정한 3자리의 수를 맞추는 기능을 한다.
4. Referee: 심판을 의미하고, 게임 플레이어가 입력한 숫자가 컴퓨터가 정한 숫자와 같은 지 판단한다. 또한, 판단한 결과(힌트)를 발표(출력)한다.

'기능 요구사항'에 명시된 컴퓨터(상대방)는 Hitter와 Referee를 합친 개념이다. 컴퓨터(상대방)가 하는 일이 1에서 9까지 서로 다른 임의의 수 3개를 선택하고, 게임 플레이어가 입력한 숫자에 대한 결과를 출력하는 것인데, 그 기능들을 프로그램 안에서는 Hitter와 Referee가 나눠서 한다.

'기능 요구사항'에 명시된 게임 플레이어는 Pitcher와 같은 개념이다. 

## 특이 사항

일반적인 야구는 투수가 공을 던지고 타자가 그 공을 친 후 심판이 결과를 판정하는 순서로 진행된다. 하지만, 숫자 야구 게임에서는 타자가 먼저 자기가 칠 공(방향)을 정하고, 이후 투수가 던지는(타자의 방향을 맞추는) 순서로 진행된다.

## 기능 목록

2. 타자(Hitter)가 자기가 칠 세 개의 공(혹은 공의 방향)을 정하는 기능. 즉, 임의의 서로 다른 세 자리 숫자를 정하는 기능.
3. 투수(Pitcher)가 3번 공을 던지는 기능. 즉, 콘솔을 통하여 게임 플레이어의 입력을 받는 기능.
4. 심판(Referee)이 투수(Picher)가 타자(Hitter)의 공(혹은 공의 방향)을 얼마나 맞췄는 지 판단하는 기능. 즉, 타자(Hitter)가 정한 3자리 숫자와 게임 플레이어가 입력한 3자리 숫자가 같은 지, 혹은 얼마나 유사한 지 판단하는 기능.
5. 심판(Referee)이 타자(Hitter)와 투수(Pitcher)의 경합 결과를 발표하는 기능. 즉, 결과를 출력하는 기능.
6. 투수(Pitcher)가 승리하지(맞추지) 못할 경우, 승리할 때까지 반복하는 기능.
7. 투수(Pitcher)가 승리할 경우, 게임을 다시 할 지, 아니면 완전히 종료할 지 정하는 기능.