package baseball.util;

import java.util.Arrays;

public class Validator {

    public static final int REQUIRE_NUMBER_COUNT = 3;
    public static final int INPUT_MAX_NUMBER = 9;
    public static final int INPUT_MIN_NUMBER = 1;
    public static final int COMMAND_RESTART = 1;
    public static final int COMMAND_END = 2;
    private static final int COMMAND_LENGTH = 1;

    private static final String INVALID_TYPE_MESSAGE = "숫자만 입력하세요.";
    private static final String DUPLICATE_MESSAGE = "중복된 숫자가 있습니다.";
    private static final String INVALID_NUMBER_MESSAGE = String.format("%d~%d의 범위에서 %d개를 선택하세요.ex)123,921"
            , INPUT_MIN_NUMBER, INPUT_MAX_NUMBER, REQUIRE_NUMBER_COUNT);


    public static void validateInput(String input) {

        if (!isIntType(input)) {
            throw new IllegalArgumentException(INVALID_TYPE_MESSAGE);
        }

        if (!isValidLength(input) || isIncludeZero(input)) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }

        if (hasDuplicate(input)) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    private static boolean isIncludeZero(String input) {
        return input.contains("0");
    }

    private static boolean isIntType(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidLength(String input) {
        return input.length() == REQUIRE_NUMBER_COUNT;
    }

    private static boolean hasDuplicate(String input) {
        return getDistinctCount(input) < REQUIRE_NUMBER_COUNT;
    }

    private static long getDistinctCount(String input) {
        return Arrays.stream(input.split(""))
                .distinct()
                .count();
    }


    public static void validateRestart(String input) {

        if (input.isEmpty() || input == null) {
            throw new IllegalArgumentException();
        }

        if (input.length() != COMMAND_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (!isIntType(input)) {
            throw new IllegalArgumentException();
        }

        int parseInt = Integer.parseInt(input);
        if (parseInt != COMMAND_END && parseInt != COMMAND_RESTART) {
            throw new IllegalArgumentException();
        }

    }

}
