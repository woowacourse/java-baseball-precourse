package baseball.validator;

public class PositiveIntegerValidator {
    private static final String IS_NOT_NUMERIC = "입력값은 숫자이어야 합니다.";
    private static final String IS_NOT_POSITIVE = "입력값은 양수이어야 합니다.";
    private static final int ZERO = 0;

    private PositiveIntegerValidator() {
    }

    public static void validatePositiveInteger(String input) {
        try {
            validateInputIsNumeric(input);
            validateInputIsPositive(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static void validateInputIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(IS_NOT_NUMERIC);
        }
    }

    private static void validateInputIsPositive(String input) {
        int integer = Integer.parseInt(input);
        if (isNegative(integer)) {
            throw new IllegalArgumentException(IS_NOT_POSITIVE);
        }
    }

    private static boolean isNegative(int input) {
        return input < ZERO;
    }
}
