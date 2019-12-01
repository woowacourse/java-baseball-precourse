/*
 * @(#)IntegerUtils.java
 *
 * v 0.0.0
 *
 * 2019.12.02
 *
 * Copyright 2019. DunDung all rights reserved.
 */

public class IntegerUtils {
    private static final int DIVISION_VALUE = 10;

    public static int[] toIntegerArray(int digit, int value) {
        int[] integerArray = new int[digit];

        for (int i = digit - 1; i >= 0; i--) {
            integerArray[i] = value % DIVISION_VALUE;
            value /= DIVISION_VALUE;
        }
        return integerArray;
    }
}
