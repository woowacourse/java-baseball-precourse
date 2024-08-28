package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputException {
    private static final String NOT_NUMBER = "숫자가 아닙니다.";
    private static final String NOT_NUMBER_LENGTH = "숫자의 길이가 맞지 않습니다.";
    private static final String DUPLICATE = "중복된 숫자가 있습니다.";
    private static final String OUT_OF_RANGE = "숫자가 1~9 범위를 벗어났습니다.";
    private static final String NUMBER_REGEX = "^[0-9]*$";

    private InputException() {
    }

    public static void validatesNumber(String inputNumbers) {
        isNumber(inputNumbers);
        isLength(inputNumbers);
        isDuplicate(inputNumbers);
        isInRange(inputNumbers);
    }

    public static void isNumber(String inputNumbers) {
        if (!Pattern.matches(NUMBER_REGEX, inputNumbers)) {
            exception(NOT_NUMBER);
        }
    }

    public static void isLength(String inputNumbers) {
        if (inputNumbers.length() != 3) {
            exception(NOT_NUMBER_LENGTH);
        }
    }

    public static void isDuplicate(String inputNumbers) {
        List<String> inputNumberList = Arrays.asList(inputNumbers.split(""));
        if (inputNumberList.stream().distinct().count() < 3) {
            exception(DUPLICATE);
        }
    }

    public static void isInRange(String inputNumbers) {
        List<String> inputNumberList = Arrays.asList(inputNumbers.split(""));
        for (String num : inputNumberList) {
            int number = Integer.parseInt(num);
            if (number < 1 || number > 9) {
                exception(OUT_OF_RANGE);
            }
        }
    }

    private static void exception(String message) {
        throw new IllegalArgumentException(message);
    }
}
