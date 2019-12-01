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
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    private static final int COMPARE_VALUE = 0;
    private static final int RESET_VALUE = 0;
    private static final int ANSWER_STRIKE = 3;
    private int[] randomNumbers;
    private int strike = 0;
    private int ball = 0;

    public NumberBaseBallGame() {
        randomNumbers = new RandomNumber().create();
    }

    public void calculateResult(int playerNumber) {
        int[] playerNumbers = IntegerUtils.toIntegerArray(DIGIT, playerNumber);
        int[] clonedRandomNumbers = randomNumbers.clone();

        Arrays.sort(clonedRandomNumbers);

        initStrikeAndBall();
        for (int i = 0; i < DIGIT; i++) {
            if (randomNumbers[i] == playerNumbers[i]) {
                strike++;
            } else if (Arrays.binarySearch(clonedRandomNumbers, playerNumbers[i]) >= COMPARE_VALUE) {
                ball++;
            }
        }
    }

    public void initStrikeAndBall() {
        strike = RESET_VALUE;
        ball = RESET_VALUE;
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
}
