/*
 * Outputview.java
 * java-baseball-precourse
 *
 * Version 0.2
 *
 * Created by 김경준 on 28/11/2019.
 *
 * Copyright © 2019 kouz95. All rights reserved.
 */

package view;

import domain.BaseballGame;

public class OutputView {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printStrikeAndBall(int strikeNumber, int ballNumber) {
        if(strikeNumber != 0 && ballNumber != 0) {
            System.out.println(strikeNumber + " " + STRIKE + " " + ballNumber + BALL);
            return;
        }
        if(strikeNumber != 0) {
            System.out.println(strikeNumber + " " + STRIKE);
            return;
        }
        if(ballNumber != 0) {
            System.out.println(ballNumber + BALL);
        }
    }

    public static void printNothingMessage() {
        System.out.println(NOTHING_MESSAGE);
    }

    public static void printWinningMessage() {
        System.out.println(WINNING_MESSAGE);
    }
}
