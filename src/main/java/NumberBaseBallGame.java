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
    private static final int INITIAL_VALUE = 0;
    private int[] randomNumbers;

    public Result createResult(int playerNumber) {
        int[] playerNumbers = IntegerUtils.toIntegerArray(DIGIT, playerNumber);
        int[] clonedRandomNumbers = randomNumbers.clone();
        int strike = INITIAL_VALUE;
        int ball = INITIAL_VALUE;

        Arrays.sort(clonedRandomNumbers);

        for (int i = 0; i < DIGIT; i++) {
            if (randomNumbers[i] == playerNumbers[i]) {
                strike++;
            } else if (Arrays.binarySearch(clonedRandomNumbers, playerNumbers[i]) >= COMPARE_VALUE) {
                ball++;
            }
        }

        return new Result(strike, ball);
    }

    public void setRandomNumbers(int[] randomNumbers) {
        this.randomNumbers = randomNumbers;
    }
}
