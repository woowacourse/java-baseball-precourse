/*
 * @(#)NumberBaseBallGame.java
 *
 * v 0.0.0
 *
 * 2019.11.28
 *
 * Copyright 2019. DunDung all rights reserved.
 */

import java.util.Arrays;

public class NumberBaseBallGame {
    public static final int DIGIT = 3;
    private static final int ZERO = 0;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int DIVISION_VALUE = 10;
    private static final int ANSWER_STRIKE = 3;
    private int[] randomNumbers;
    private int[] playerNumbers = new int[DIGIT];
    private int strike = 0;
    private int ball = 0;

    public NumberBaseBallGame() {
        randomNumbers = RandomNumber.create(DIGIT, MIN_VALUE, MAX_VALUE);
    }

    public void calculateResult() {
        initStrikeAndBall();

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

    public void initStrikeAndBall() {
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
        for (int i=DIGIT-1; i>=0; i--) {
            playerNumbers[i] = playerNumber % DIVISION_VALUE;
            playerNumber /= DIVISION_VALUE;
        }
    }
}
