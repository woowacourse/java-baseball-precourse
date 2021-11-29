package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private static final int RANDOM_START_INCLUSIVE = 1;
    private static final int RANDOM_END_INCLUSIVE = 9;

    public String makeAnswerNumber() {
        final StringBuilder stringBuilder = new StringBuilder();

        while (checkLength(stringBuilder)) {
            int number = inputAnswerNumber();

            if (!checkDuplicateAnswerNumber(stringBuilder, number)) {
                connectAnswerNumbers(stringBuilder, number);
            }
        }

        return stringBuilder.toString();
    }

    private void connectAnswerNumbers(final StringBuilder stringBuilder, final int number) {
        stringBuilder.append(number);
    }

    private boolean checkDuplicateAnswerNumber(final StringBuilder stringBuilder, final int number) {
        return stringBuilder.toString().contains(String.valueOf(number));
    }

    private int inputAnswerNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
    }

    private boolean checkLength(final StringBuilder stringBuilder) {
        return stringBuilder.length() < 3;
    }

}
