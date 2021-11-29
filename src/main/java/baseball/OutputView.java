package baseball;

public class OutputView {
    public static void numberInputMessageShow() {
        System.out.print(Constant.NUMBER_INPUT_ALARM_MESSAGE);
    }

    public static void gameEndMessageShow() {
        System.out.println(Constant.GAME_RESTART_OR_EXIT_MESSAGE);
    }

    public static void gameResultShow(int stikeCount, int ballCount) {
        if (stikeCount == Constant.BALL_LIST_SIZE) {
            System.out.println(stikeCount + Constant.OUTPUT_STRIKE_MESSAGE);
            System.out.println(Constant.GAME_WIN_MESSAGE);
        } else if (stikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + Constant.OUTPUT_BALL_MESSAGE + " " + stikeCount + Constant.OUTPUT_STRIKE_MESSAGE);
        } else if (stikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + Constant.OUTPUT_BALL_MESSAGE);
        } else if (stikeCount > 0 && ballCount == 0) {
            System.out.println(stikeCount + Constant.OUTPUT_STRIKE_MESSAGE);
        } else {
            System.out.println(Constant.OUTPUT_NOTHING_MESSAGE);
        }
    }
}
