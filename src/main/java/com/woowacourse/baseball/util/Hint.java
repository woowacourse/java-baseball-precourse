/*
 * Hint.java
 * version 1.0
 * 2019.03.28
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package com.woowacourse.baseball.util;

import java.util.ArrayList;

/**
 * Hint represents the result of comparing answer and user input.
 */
public class Hint {
    private int strike;
    private int ball;
    private boolean status;

    /**
     * compareNumbers compares random answer with user trial
     * and decides strike, ball count.
     * @param answer : computer's answer
     * @param input : user's trial
     */
    public void compareNumbers(ArrayList<Integer> answer,
                               ArrayList<Integer> input) {
        strike      = 0;
        ball        = 0;

        for (int i=0; i<Constants.NUMBER_LENGTH; i++) {
            if (answer.get(i).equals(input.get(i))) {
                strike++;
            } else if (answer.contains(input.get(i))){
                ball++;
            }
        }
    }

    /**
     * printHint updates status (true if correct)
     * and prints hint string.
     */
    public void printHint() {
        if (Constants.NUMBER_LENGTH == strike) {
            System.out.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n",
                                Constants.NUMBER_LENGTH);
            status = true;
        } else if (strike==0 && ball==0){
            System.out.println("낫싱");
            status = false;
        } else {
            System.out.format("%d 스트라이크 %d 볼\n", strike, ball);
            status = false;
        }
    }

    /**
     * getStatus returns status
     * @return true if user is correct
     */
    public boolean getStatus() {
        return status;
    }
}
