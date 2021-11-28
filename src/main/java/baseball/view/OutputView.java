package baseball.view;

import baseball.constant.SystemMessage;

public class OutputView {
    public static void printBallMessage() {
        System.out.printf(SystemMessage.BALL_MESSAGE);
    }

    public static void printStrikeMessage() {
        System.out.printf(SystemMessage.STRIKE_MESSAGE);
    }

    public static void printNothingMessage() {
        System.out.printf(SystemMessage.NOTHING_MESSAGE);
    }

    public static void printCount(int count) {
        System.out.print(count);
    }

    public static void printSuccessMessage() {
        System.out.printf(SystemMessage.SUCCESS_FIND_ALL_NUMBER);
    }

    public static void printGameSetMessage() {
        System.out.println(SystemMessage.GAME_SET_MESSAGE);
    }
}
