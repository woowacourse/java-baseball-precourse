/*
 * @(#)NumberBaseBallGame.java
 *
 * v 0.0.0
 *
 * 2019.11.28
 *
 * Copyright 2019. DunDung all rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberBaseBallGame {
    public static final int DIGIT = 3;
    private static final int ZERO = 0;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int DIVISION_VALUE = 10;
    private static final int ANSWER_STRIKE = 3;
    private int[] randomNumbers = new int[DIGIT];
    private int[] playerNumbers = new int[DIGIT];
    private int strike = 0;
    private int ball = 0;

    public NumberBaseBallGame() {
        List<Integer> availableNumberList = new ArrayList<>();
        for (int i=MIN_VALUE; i<=MAX_VALUE; i++) {
            availableNumberList.add(i);
        }

        Collections.shuffle(availableNumberList);

        for (int i=0; i<DIGIT; i++) {
            randomNumbers[i] = availableNumberList.get(i);
        }
        for(int k : randomNumbers) {
            System.out.print(k);
        }
        System.out.println();
    }

    public void calculateResult() {
        initStringAndBall();

        int[] cloneRandomNumbers = randomNumbers.clone();
        Arrays.sort(cloneRandomNumbers);

        for (int i=0; i<DIGIT; i++) {
            if (randomNumbers[i] == playerNumbers[i]){
                strike++;
            } else if (Arrays.binarySearch(cloneRandomNumbers, playerNumbers[i]) >= ZERO) {
                ball++;
            }
        }

    }

    public void initStringAndBall() {
        strike = ZERO;
        ball = ZERO;
    }


    public boolean isAnswer() {
        return this.strike == ANSWER_STRIKE;
    }


    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void setPlayerNumber(int playerNumber) {
        for(int i=DIGIT-1; i>=0; i--) {
            playerNumbers[i] = playerNumber % DIVISION_VALUE;
            playerNumber /= DIVISION_VALUE;
        }
    }
}
