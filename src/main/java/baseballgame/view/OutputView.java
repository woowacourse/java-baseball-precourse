package baseballgame.view;

import baseballgame.BallCount;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-12-03
 */
public class OutputView {

    private static final String MESSAGE_START_GAME = "# 새로운 게임을 시작합니다.";
    private static final String MESSAGE_EXIT_GAME = "# 게임을 종료합니다.";
    private static final String MESSAGE_CORRECT_NUMBER = "# 정답입니다.";

    public static void showStartMessage() {
        System.out.println(MESSAGE_START_GAME);
    }

    public static void showExitMessage() {
        System.out.println(MESSAGE_EXIT_GAME);
    }

    public static void showCorrectMessage() {
        System.out.println(MESSAGE_CORRECT_NUMBER);
    }

    public static void showBallCountMessage(BallCount ballCount) {
        System.out.println(ballCount);
    }
}
