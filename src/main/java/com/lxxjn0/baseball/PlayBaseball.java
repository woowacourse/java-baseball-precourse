/*
 * @(#)PlayBaseball.java        0.2 2019/12/01
 *
 * Copyright (c) 2019 lxxjn0.
 */
package com.lxxjn0.baseball;

import java.util.ArrayList;

/**
 * 게임의 전체적인 진행을 담당하고 컴퓨터와 사용자로부터 3자리 숫자를 저장하고 이를 통해 스트라이크와 볼, 그리고 낫싱 여부를 구해서 저장.
 * 위 결과를 통해 답과 일치하는지 여부를 판단하고 사용자로부터 입력을 받아서 게임의 진행 여부 결정하는 클래스.
 *
 * @version         0.2 2019/12/01
 * @author          JUNYOUNG LEE (lxxjn0)
 */
public class PlayBaseball {
    /** 입력해야 하는 수의 길이를 저장한 상수 변수 */
    private static final int NUM_LEN = 3;
    /** 스트라이크 또는 볼이 0개인 경우를 판단하기 위한 상수 변수 */
    private static final int COUNT_ZERO = 0;
    /** 컴퓨터가 생성한 3자리 수를 저장할 ArrayList */
    private ArrayList<Integer> comNumList;
    /** 사용자가 입력한 3자리 수를 저장할 ArrayList*/
    private ArrayList<Integer> userNumList;

    /**
     * 사용자의 입력에 따라서 게임을 다시 시작하거나 종료하는 메서드.
     */
    public void Play() {
        do {
            run();
        }while(continuePlay());
    }

    /**
     * 실질적인 게임(3자리 수 생성부터 답과 일치하면 종료하는 기능까지)이 진행되는 메서드.
     */
    private void run() {
        Computer computer = new Computer();
        User user;
        Referee referee;
        int countStrike;
        int countBall;

        do {
            user = new User();
            referee = new Referee();

            comNumList = computer.getNumList();
            userNumList = user.getNumList();
            referee.setComNumList(comNumList);
            referee.setUserNumList(userNumList);

            if(referee.judgeNothing()) {
                countStrike = COUNT_ZERO;
                System.out.println("낫싱");
            }
            else {
                countStrike = referee.countStrikeNum();
                countBall = referee.countBallNum();
                if(countStrike == COUNT_ZERO) {
                    System.out.printf("%d 볼\n", countBall);
                }
                else if(countBall == COUNT_ZERO) {
                    System.out.printf("%d 스트라이크\n", countStrike);
                }
                else {
                    System.out.printf("%d 스트라이크 %d볼\n", countStrike, countBall);
                }
            }
        }while(!(countStrike == NUM_LEN));
    }

    /**
     * 사용자로부터 입력을 받아 게임을 다시 시작 또는 종료 여부를 결정하는 메서드.
     * @return 게임을 다시 시작할 경우 true를 반환한다.
     */
    private boolean continuePlay() {
        return User.continueCheck();
    }
}