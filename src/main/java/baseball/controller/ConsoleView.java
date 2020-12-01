package baseball.controller;

public class ConsoleView {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static final String PRINT_BALL_MESSAGE = "볼 ";
    private static final String PRINT_STRIKE_MESSAGE = "스트라이크";
    private static final String PRINT_NOTING_MESSAGE = "낫싱";

    private static final int SUCCESS_REQUIRE_COUNT = 3;
    private static final int NONE_USEFUL_NUMBER = 0;
    private static String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_CLEAR_MESSAGE =
            String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", SUCCESS_REQUIRE_COUNT);


    private static void resetStringBuilder() {
        stringBuilder.setLength(0);
    }

    public void printResult() {
        if (stringBuilder.length() == NONE_USEFUL_NUMBER) {
            printNothing();
            return;
        }

        System.out.println(stringBuilder.toString());
        resetStringBuilder();
    }

    public void setBallCount(int ballCount) {

        if (ballCount == NONE_USEFUL_NUMBER) {
            return;
        }
        appendBall(ballCount);
    }

    private void appendBall(int ballCount) {
        stringBuilder.append(ballCount + PRINT_BALL_MESSAGE);
    }

    public void setStrikeCount(int strikeCount) {


        if (strikeCount == SUCCESS_REQUIRE_COUNT) {
            appendGameSuccess();
            return;
        }

        if (strikeCount == NONE_USEFUL_NUMBER) {
            return;
        }
        appendStrike(strikeCount);
    }

    private void appendStrike(int strikeCount) {
        stringBuilder.append(strikeCount + PRINT_STRIKE_MESSAGE);
    }


    private void printNothing() {
        System.out.println(PRINT_NOTING_MESSAGE);
    }

    private void appendGameSuccess() {
        if (stringBuilder.length() != NONE_USEFUL_NUMBER) {
            resetStringBuilder();
        }
        stringBuilder.append(GAME_CLEAR_MESSAGE);
    }


    public static void printRestart() {
        System.out.println(GAME_RESTART_MESSAGE);
    }

}
