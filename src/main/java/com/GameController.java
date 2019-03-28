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

    public void askUsersGuessNumber() {
        System.out.print("숫자를 입력해주세요 :");
        scanner = new Scanner(System.in);
        userNumber = scanner.nextLine();
    }

    /* 게임이 다 끝나고 재시작여부 확인 및 리셋 */
    public void askGameRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        int e = scanner.nextInt();      /* 1과 2 받는 임의의 변수 */

        if(e == 1){
            computer.reSetComNumber();  /* 컴퓨터가 갖고 있는 중복체크 판을 초기화 */
            referee.reset();            /* 심판이 갖고 있는 볼, 스트라이크 수를 초기화 */
        }else{
            gameState = false;
        }
    }

    /* 사용자가 입력하는 값이 3개이상 같은수 인지 확인 */
    public boolean checkTheInput() {

        if (userNumber.length() > BALL_LENGTH) {       /* 입력받은 길이와 기준치를 비교 */
            return false;
        }

        for (int i=0; i < BALL_LENGTH; i++) {
            if (checkSameNumber(userNumber.charAt(i),i+1)) {
                return false;
            }
        }
        return true;
    }

    /* userNumber를 하나씩 받아서 중복된 수가 있는지 확인 */
    public boolean checkSameNumber(char each, int start) {
        for (int k = start; k < BALL_LENGTH; k++) {
            if (each == userNumber.charAt(k)) {
                return true;
            }
        }
        return false;
    }

}


