/*
 * DefaultTest.java
 * version 1.0
 * 2019.03.28
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package com.woowacourse.baseball.testutil;

/**
 * DefaultTest
 */
abstract class DefaultTest {
    int testCount;      // total number of tests
    int correctAnswer;  // number of tests got right

    /**
     * DefaultTest constructor.
     * Initializes testCount and correctAnswer.
     */
    DefaultTest() {
        testCount       = 0;
        correctAnswer   = 0;
    }

    /**
     * test will perform class-defined tests
     * and store result in testCount, correctAnswer
     * @param args
     */
    public abstract void test(String [] args);

    /**
     * printResult prints number of tests correct/total.
     */
    public void printResult() {
        System.out.format("%d/%d CORRECT!\n", correctAnswer, testCount);
    };
}
