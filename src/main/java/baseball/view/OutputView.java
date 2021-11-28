package baseball.view;

import baseball.domain.GameResult;

public class OutputView {
    private static final String BALL_COUNT_MESSAGE = "%d볼 ";
    private static final String STRIKE_COUNT_MESSAGE = "%d스트라이크";
    private static final String NOTHING_COUNT_MESSAGE = "낫싱";
    private static final String GAME_RESULT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void showHintMessage(GameResult result) {
        if (result.getBallCount() > 0) {
            System.out.printf(BALL_COUNT_MESSAGE, result.getBallCount());
        }
        if (result.getStrikeCount() > 0) {
            System.out.printf(STRIKE_COUNT_MESSAGE, result.getStrikeCount());
        }
        if (result.getBallCount() == 0 && result.getStrikeCount() == 0) {
            System.out.print(NOTHING_COUNT_MESSAGE);
        }
        System.out.println();
    }

    public static void showGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }
}