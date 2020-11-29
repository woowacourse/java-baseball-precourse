package baseball.service;

import baseball.constant.Constants;

public class CountValidator {

    private CountValidator() {
    }

    public static boolean isAllStrike(int strikeCount) {
        return strikeCount == Constants.ANSWER_LENGTH;
    }

    public static boolean isNothing(int ballCount, int strikeCount) {
        return (ballCount + strikeCount) == Constants.VALUE_ZERO;
    }
}
