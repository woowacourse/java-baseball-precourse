/*
 * Input.java
 * version 1.0
 * 2019.03.28
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package com.woowacourse.baseball.util;

import java.util.ArrayList;
import java.util.Scanner;
import com.woowacourse.baseball.util.NumberValidation;

/**
 * Input represents player User.
 */
public class Input {
    private ArrayList<Integer> input = new ArrayList<>();

    /**
     * setInput receives and saves user's trial input.
     * @param scan
     */
    public void setInput(Scanner scan) {
        String inputString = new String();
        boolean validInput  = false;

        System.out.print("숫자를 입력해주세요 : ");
        while (!validInput) {
            inputString = scan.nextLine().trim();
            if (!NumberValidation.checkLength(inputString)) {
                System.out.format("%d자리 숫자를 입력해주세요 : ",
                        Constants.NUMBER_LENGTH);
            } else if (!NumberValidation.checkDiff(inputString)) {
                System.out.print("서로 다른 숫자를 사용해주세요 : ");
            } else if (!NumberValidation.checkRange(inputString)) {
                System.out.format("숫자 %d-%d를 사용해주세요 : ",
                        Constants.NUMBER_LOWER_BOUND,
                        Constants.NUMBER_UPPER_BOUND);
            } else {
                validInput = true;
            }
        }

        for (char c : inputString.toCharArray()) {
            input.add(Character.getNumericValue(c));
        }
    }

    /**
     * getInput returns input ArrayList.
     * @return ArrayList<Integer> : user provided input
     */
    public ArrayList<Integer> getInput() {
        return input;
    }
}
