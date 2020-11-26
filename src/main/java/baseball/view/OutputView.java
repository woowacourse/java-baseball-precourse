/*
 * OutputView.java
 *
 * version 1.0
 *
 * 2020/11/27
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package baseball.view;

public class OutputView {
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printBallCount(int ball, int strike) {
        if ((strike != 0) && (ball != 0)) {
            System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
            return;
        }
        if (strike != 0) {
            System.out.println(strike + STRIKE_MESSAGE);
            return;
        }
        if (ball != 0) {
            System.out.println(ball + BALL_MESSAGE);
            return;
        }
        if ((strike == 0) && (ball == 0)){
            System.out.println(NOTHING_MESSAGE);
            return;
        }
    }

    public static void printWinning() {
        System.out.println(WINNING_MESSAGE);
    }

}
