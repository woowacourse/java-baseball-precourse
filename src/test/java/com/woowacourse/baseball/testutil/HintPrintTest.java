/*
 * HintPrintTest.java
 * version 1.0
 * 2019.03.28
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package com.woowacourse.baseball.testutil;

import com.woowacourse.baseball.util.Hint;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.System;

public class HintPrintTest extends DefaultTest {

    /**
     * test takes printed hint and compare with expected hint.
     * @param args : [0] computer answer mock
     *               [1] user input mock
     *               [2] expected hint
     */
    @Override
    public void test(String[] args) {
        PrintStream original        = System.out;
        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream printstream     = new PrintStream(baos);
        Hint testResult             = new Hint();
        ArrayList<Integer> answer   = makeArrayList(args[0]);
        ArrayList<Integer> input    = makeArrayList(args[1]);

        System.setOut(printstream);

        testResult.compareNumbers(answer, input);
        testResult.printHint();

        System.setOut(original);

        if (baos.toString().equals(args[2])) {
            correctAnswer++;
        } else {
            System.out.println(args[0]);
            System.out.println(args[1]);
            System.out.println(args[2]);
        }
        testCount++;
    }

    /**
     * makeArrayList converts "123" to [1, 2, 3].
     * @param numberStr : number saved as String
     * @return ArrayList of each digits in number String
     */
    private static ArrayList<Integer> makeArrayList(String numberStr) {
        ArrayList<Integer> numberArray = new ArrayList<>();

        for (char c : numberStr.toCharArray()) {
            numberArray.add(Character.getNumericValue(c));
        }
        return numberArray;
    }
}
