package utils;
import baseball.Numbers;
import baseball.PlayButton;

public class InputValidator {
    private static final String INVALID_LENGTH_MSG = "잘못된 입력 길이입니다. ";
    private static final String INVALID_RANGE_MSG = "범위 외 입력입니다. ";
    private static final String INVALID_DUPLICATE_MSG = "중복이 포함된 입력입니다. ";

    private InputValidator(){}

    public static void checkValidPlayAgainBtn(String input) throws IllegalArgumentException {
        if (!StringHandler.isValidLength(input, PlayButton.LEN)) {
            throw new IllegalArgumentException(INVALID_LENGTH_MSG);
        }

        if (!StringHandler.isInRange(input, PlayButton.MIN, PlayButton.MAX)) {
            throw new IllegalArgumentException(INVALID_RANGE_MSG);
        }
    }

    public static void checkValidNumbers(String input, int len) throws IllegalArgumentException {
        if (!StringHandler.isValidLength(input, len)) {
            throw new IllegalArgumentException(INVALID_LENGTH_MSG);
        }

        if (!StringHandler.isInRange(input, Numbers.MIN, Numbers.MAX)) {
            throw new IllegalArgumentException(INVALID_RANGE_MSG);
        }

        if (!StringHandler.isAllDifferent(input)) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_MSG);
        }
    }
}
