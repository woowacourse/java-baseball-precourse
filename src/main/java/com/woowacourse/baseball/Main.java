/*
 * Main.java
 * version 1.0
 * 2019.03.28
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package com.woowacourse.baseball;

import java.util.Scanner;
import com.woowacourse.baseball.util.Answer;
import com.woowacourse.baseball.util.Constants;
import com.woowacourse.baseball.util.Input;
import com.woowacourse.baseball.util.Hint;

/**
 * Main starts and ends the baseball game according to user input.
 */
public class Main {

    /* Strings to decide replay */
    private static String doReplay  = "1";
    private static String noReplay  = "2";
    private static String askReplay = "게임을 새로 시작하려면 1,"
                                    + " 종료하려면 2를 입력하세요.";

    /**
     * main gets user input to decide if the game should go on.
     * @param args
     */
    public static void main(String[] args) {
        String again;
        boolean playing = true;
        Scanner scan    = new Scanner(System.in);

        /* Check if it is possible to make random numbers with given condition */
        assert (Constants.NUMBER_LENGTH >= Constants.NUMBER_LOWER_BOUND)
                && (Constants.NUMBER_LENGTH <= Constants.NUMBER_UPPER_BOUND);

        while (playing) {
            playBaseball(scan);
            System.out.println(askReplay);
            again = scan.nextLine().trim();
            playing = checkReplay(again, scan);
        }

        scan.close();
    }

    /**
     * checkReplay validates user input regarding replay.
     * @param again user input.
     * @param scan
     * @return true if user wants to play again.
     */
    private static boolean checkReplay(String again, Scanner scan) {
        if (again.equals(doReplay)) {
            return true;
        } else if (again.equals(noReplay)) {
            return false;
        } else {
            System.out.println(askReplay);
            again = scan.nextLine().trim();
            return checkReplay(again, scan);
        }
    }

    /**
     * playBaseball sets the answer randomly, gets user trials,
     * and print hint strings until user is correct.
     * @param scan
     */
    private static void playBaseball(Scanner scan){
        boolean correct     = false;
        Answer randomAnswer = new Answer();

        /* Set answer randomly. */
        randomAnswer.setAnswer();

        while (!correct) {
            Input userTrial     = new Input();
            Hint computedHint   = new Hint();

            userTrial.setInput(scan);
            computedHint.compareNumbers(randomAnswer.getAnswer(),
                                        userTrial.getInput());
            computedHint.printHint();
            correct = computedHint.getStatus();
        }
    }
}
