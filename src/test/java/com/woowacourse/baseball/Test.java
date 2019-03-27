/*
 * Test.java
 * version 1.0
 * 2019.03.28
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package com.woowacourse.baseball;

import com.woowacourse.baseball.testutil.HintPrintTest;
import com.woowacourse.baseball.testutil.InputCheckTest;
import com.woowacourse.baseball.testutil.RandomTest;

/**
 * Test class is a test sheet user writes manually.
 * Three kinds of test are available.
 */
public class Test {

    /**
     * main conducts test and prints result.
     * @param args
     */
    public static void main(String[] args) {

        /* Test if hint is printed correctly. */
        HintPrintTest hintPrintTest = new HintPrintTest();
        hintPrintTest.test(new String[]{"123", "456", "낫싱\n"});
        hintPrintTest.test(new String[]{"123", "278", "0 스트라이크 1 볼\n"});
        hintPrintTest.test(new String[]{"123", "234", "0 스트라이크 2 볼\n"});
        hintPrintTest.test(new String[]{"123", "312", "0 스트라이크 3 볼\n"});
        hintPrintTest.test(new String[]{"123", "136", "1 스트라이크 1 볼\n"});
        hintPrintTest.test(new String[]{"123", "124", "2 스트라이크 0 볼\n"});
        hintPrintTest.test(new String[]{"123", "123",
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"});
        hintPrintTest.printResult();

        /* Test if input validation is done correctly. */
        InputCheckTest inputCheckTest = new InputCheckTest();
        inputCheckTest.test(new String[]{"1234", "3자리 숫자를 입력해주세요 : "});
        inputCheckTest.test(new String[]{"012", "숫자 1-9를 사용해주세요 : "});
        inputCheckTest.test(new String[]{"112", "서로 다른 숫자를 사용해주세요 : "});
        inputCheckTest.test(new String[]{"122", "서로 다른 숫자를 사용해주세요 : "});
        inputCheckTest.test(new String[]{"121", "서로 다른 숫자를 사용해주세요 : "});
        inputCheckTest.test(new String[]{"222", "서로 다른 숫자를 사용해주세요 : "});
        inputCheckTest.test(new String[]{"123", "input check passed"});
        inputCheckTest.printResult();

        /* Test if random number is generated correctly. */
        RandomTest randomTest = new RandomTest();
        for (int i=0; i<100; i++) {
            randomTest.test(new String[]{});
        }
        randomTest.printResult();
    }
}
