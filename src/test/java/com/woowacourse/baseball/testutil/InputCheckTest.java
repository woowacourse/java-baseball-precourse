/*
 * InputCheckTest.java
 * version 1.0
 * 2019.03.28
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package com.woowacourse.baseball.testutil;

import com.woowacourse.baseball.util.Constants;
import com.woowacourse.baseball.util.NumberValidation;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InputCheckTest extends DefaultTest {

    /**
     * test takes warning from input validation
     * and compares with expected warning
     * @param args : [0] user input mock
     *               [1] expected warning
     */
    @Override
    public void test(String[] args) {
        PrintStream original        = System.out;
        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream printstream     = new PrintStream(baos);

        System.setOut(printstream);

        if (!NumberValidation.checkLength(args[0])) {
            System.out.format("%d자리 숫자를 입력해주세요 : ",
                    Constants.NUMBER_LENGTH);
        } else if (!NumberValidation.checkDiff(args[0])) {
            System.out.print("서로 다른 숫자를 사용해주세요 : ");
        } else if (!NumberValidation.checkRange(args[0])) {
            System.out.format("숫자 %d-%d를 사용해주세요 : ",
                    Constants.NUMBER_LOWER_BOUND,
                    Constants.NUMBER_UPPER_BOUND);
        } else {
            System.out.print("input check passed");
        }

        System.setOut(original);

        if (baos.toString().equals(args[1])) {
            correctAnswer++;
        } else {
            System.out.println(args[0]);
            System.out.println(args[1]);
        }
        testCount++;
    }
}
