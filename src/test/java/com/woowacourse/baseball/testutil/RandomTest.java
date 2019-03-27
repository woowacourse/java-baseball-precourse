/*
 * RandomTest.java
 * version 1.0
 * 2019.03.28
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package com.woowacourse.baseball.testutil;

import com.woowacourse.baseball.util.Answer;
import com.woowacourse.baseball.util.NumberValidation;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class RandomTest extends DefaultTest {

    /**
     * test produces random number and validates it.
     * @param args
     */
    @Override
    public void test(String[] args) {
        PrintStream original        = System.out;
        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream printstream     = new PrintStream(baos);
        Answer randomAnswer         = new Answer();

        System.setOut(printstream);

        randomAnswer.setAnswer();
        ArrayList<Integer> answer = randomAnswer.getAnswer();

        System.setOut(original);

        if (checkNumber(answer)) {
            correctAnswer++;
        } else {
            System.out.println(answer.toString());
        }
        testCount++;
    }

    /**
     * checkNumber validates random number.
     * Checks number's length, digits' range,
     * and if digits are distinct.
     * @param answer : randomly generated integer array
     * @return true if passed all three tests
     */
    private boolean checkNumber(ArrayList<Integer> answer) {
        return NumberValidation.checkLength(answer)
                && NumberValidation.checkRange(answer)
                && NumberValidation.checkDiff(answer);
    }
}
