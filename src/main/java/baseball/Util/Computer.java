package baseball.Util;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private static final int RANDOM_START_INCLUSIVE = 1;
    private static final int RANDOM_END_INCLUSIVE = 9;

    public static String makeAnswerNumber() {
        final StringBuilder stringBuilder = new StringBuilder();

        while (checkLength(stringBuilder)) {
            int number = inputAnswerNumber();

            if (!checkDuplicateAnswerNumber(stringBuilder, number)) {
                connectAnswerNumbers(stringBuilder, number);
            }
        }

        return stringBuilder.toString();
    }

    private static void connectAnswerNumbers(final StringBuilder stringBuilder, final int number) {
        stringBuilder.append(number);
    }

    private static boolean checkDuplicateAnswerNumber(final StringBuilder stringBuilder, final int number) {
        return stringBuilder.toString().contains(String.valueOf(number));
    }

    private static int inputAnswerNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
    }

    private static boolean checkLength(final StringBuilder stringBuilder) {
        return stringBuilder.length() < 3;
    }

}
