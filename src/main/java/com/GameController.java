/*
* GameController.java
*
* version 1.0        2019.03.27
*
* JDK 1.8
*
* Copyright (c) 2019 Jong Min Lee.
* All right reserved.
 */

package com;

import java.util.Scanner;

/*
* 전체적인 시스템을 관리하는 클래스
* referee 와 computer 관련 정보를 다 포함하고 있습니다.
*
* @version 1.00 2018.3.27
* @author 이종민
*/

public class GameController {
    final int BALL_LENGTH = 3;      /* 던질수 있는 볼 수 */
    Scanner scanner;
    Computer computer;
    Referee referee;
    String userNumber;              /* 사용자가 예상하는 숫자 */

    boolean gameState = true;       /* 게임을 재시작해야할지 끝내야 할지의 상태를 알려주는 변수 */

    public GameController() {
        computer = new Computer(BALL_LENGTH);
        referee = new Referee();
        computer.makeNumber();
    }

    public boolean startGame() {
        return gameState;       /* 게임을 계속 해야 할지 말지 판단 */
    }

    public void playGame() {
        referee.judgeTheStrike(computer.getComputerNumber(), userNumber);   //사용자,컴퓨터수 판단

        if (referee.getStrike() == 3) {
            askGameRestart();
        } else {
            referee.getResult();
        }
    }

}


