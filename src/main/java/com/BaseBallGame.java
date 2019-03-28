/*
* BaseBallGame.java
*
* version 1.0        2019.03.27
*
* JDK 1.8
*
* Copyright (c) 2019 Jong Min Lee.
* All right reserved.
*
* 전체적인 게임 설명
*
* 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면
* 포폴 또는 낫싱이란 힌트를 얻고 ( 본 프로그램에서는 포폴로 작성 ), 그 힌트를 이용해서 먼저
* 상대방(컴퓨터)의 수를 맞추면 승리한다.
*
* 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서9까지 서로 다른 임의의 수
* 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한
* 숫자에 대한 결과를 출력한다.
*
* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
*
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
*/

package com;

/*
* 야구게임을 하기위한 클래스
* 전체적인 게임은 게임컨트롤러가 수행한다.
*
*  @version 1.00 2018.3.27
*  @author 이종민
*/

public class BaseBallGame {

    public static void main(String[] args) {
        GameController controller = new GameController();

        while (controller.startGame()) {
            controller.askUsersGuessNumber();

            if(controller.checkTheInput()) {
                controller.playGame();
            }
        }
    }

}
