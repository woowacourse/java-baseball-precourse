package baseball.view;

import baseball.domain.computer.GameResult;

public class ResultView {

    private static String LINE_BREAK = "%n";
    private static String BLANK = " ";

    private static String GAME_RESULT_NOTHING_MESSAGE = "낫싱";
    private static String GAME_RESULT_BALL_MESSAGE = "%d볼";
    private static String GAME_RESULT_STRIKE_MESSAGE = "%d스트라이크";

    private ResultView() {
    }

    public static void viewGameResult(GameResult gameResult) {
        if (gameResult.isNothing()) {
            System.out.println(GAME_RESULT_NOTHING_MESSAGE);
            return;
        }
        if (gameResult.ballCount() == 0) {
            System.out.printf(GAME_RESULT_STRIKE_MESSAGE + LINE_BREAK, gameResult.strikeCount());
            return;
        }
        if (gameResult.strikeCount() == 0) {
            System.out.printf(GAME_RESULT_BALL_MESSAGE + LINE_BREAK, gameResult.ballCount());
            return;
        }
        System.out.printf(GAME_RESULT_BALL_MESSAGE + BLANK + GAME_RESULT_STRIKE_MESSAGE, gameResult.ballCount(),
            gameResult.strikeCount());
    }
}
