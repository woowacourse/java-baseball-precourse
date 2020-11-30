package baseball.controller;

import utils.Validator;

public class ConsoleView {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static final String PRINT_BALL_MESSAGE = "볼 ";
    private static final String PRINT_STRIKE_MESSAGE = "스트라이크";
    private static final String PRINT_NOTING_MESSAGE = "낫싱";

    private static final int SUCCESS_REQUIRE_COUNT = 3;
    private static final int NONE_USEFUL_NUMBER = 0;
    private static final String GAME_CLEAR_MESSAGE =
            String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료",SUCCESS_REQUIRE_COUNT);


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

        validateCount(ballCount);

        if (ballCount == NONE_USEFUL_NUMBER) {
            return;
        }
        stringBuilder.append(ballCount + PRINT_BALL_MESSAGE);

    }

    public void setStrikeCount(int strikeCount) {

        validateCount(strikeCount);

        if (strikeCount == NONE_USEFUL_NUMBER) {
            return;
        }
        if (strikeCount == SUCCESS_REQUIRE_COUNT) {
            printGameSuccess();
            return;
        }
        stringBuilder.append(strikeCount + PRINT_STRIKE_MESSAGE);
    }


    private void printNothing() {
        System.out.println(PRINT_NOTING_MESSAGE);
    }

    private void printGameSuccess() {
        if (stringBuilder.length() != NONE_USEFUL_NUMBER) {
            resetStringBuilder();
        }
        stringBuilder.append(GAME_CLEAR_MESSAGE);
    }

    private void validateCount(int count){
        if(count > Validator.REQUIRE_NUMBER_COUNT || count < NONE_USEFUL_NUMBER){
            throw new IllegalArgumentException();
        }
    }

}
