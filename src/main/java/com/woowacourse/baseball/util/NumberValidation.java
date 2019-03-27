/*
 * NumberValidation.java
 * version 1.0
 * 2019.03.28
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package com.woowacourse.baseball.util;

import java.util.ArrayList;

/**
 * NumberValidation checks length and range of number,
 * if numbers are the same
 */
public class NumberValidation {

    /**
     *
     * @param inputArray : number to check stored in ArrayList
     * @return true if length is appropriate
     */
    public static boolean checkLength(ArrayList<Integer> inputArray) {
        return inputArray.size() == Constants.NUMBER_LENGTH;
    }

    /**
     *
     * @param inputString : number to check stored in String
     * @return true if length is appropriate
     */
    public static boolean checkLength(String inputString) {
        return inputString.length() == Constants.NUMBER_LENGTH;
    }

    /**
     *
     * @param inputArray : number to check stored in ArrayList
     * @return true if digit range is appropriate
     */
    public static boolean checkRange(ArrayList<Integer> inputArray) {
        for (int i : inputArray) {
            if (i < Constants.NUMBER_LOWER_BOUND
                    || i > Constants.NUMBER_UPPER_BOUND) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param inputString : number to check stored in String
     * @return true if digit range is appropriate
     */
    public static boolean checkRange(String inputString) {
        int now;
        for (char c : inputString.toCharArray()) {
            now = Character.getNumericValue(c);
            if (now < Constants.NUMBER_LOWER_BOUND
                    || now > Constants.NUMBER_UPPER_BOUND) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param inputArray : number to check stored in ArrayList
     * @return true if all digits are distinct
     */
    public static boolean checkDiff(ArrayList<Integer> inputArray) {
        ArrayList<Integer> input = new ArrayList<>();

        for (int i : inputArray) {
            if (input.contains(i)) {
                return false;
            }
            input.add(i);
        }
        return true;
    }

    /**
     *
     * @param inputString : number to check stored in String
     * @return true if all digits are distinct
     */
    public static boolean checkDiff(String inputString) {
        int now;
        ArrayList<Integer> input = new ArrayList<>();

        for (char c : inputString.toCharArray()) {
            now = Character.getNumericValue(c);
            if (input.contains(now)) {
                return false;
            }
            input.add(now);
        }
        return true;
    }
}
