package baseball;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Validator {

    private final static int START = 1;
    private final static int END = 2;
    private final static int DIGIT = 3;
    private final static String NUMBER_PATTERN = "[+-]?\\d*(\\.\\d+)?";
    private final static String WRONG_INPUT_MESSAGE = "입력값이 올바르지 않습니다.";

    private String input;

    public void validateInputNumber(String input) {
        this.input = input;

        boolean isNumber = this.input.matches(NUMBER_PATTERN);

        if (!isNumber || isContainsZero() || isContainsDuplicatedNumber() || !isCorrectDigit()) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }

    public void validateRestartInput(String input) {
        boolean isNumber = this.input.matches(NUMBER_PATTERN);

        if (!isNumber && (Integer.parseInt(input) != START || Integer.parseInt(input) != END)) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }

    private boolean isCorrectDigit() {
        return input.length() == DIGIT;
    }

    private boolean isContainsZero() {
        return input.contains("0");
    }

    private boolean isContainsDuplicatedNumber() {
        String duplicated = Arrays.stream(input.split(""))
                .distinct()
                .collect(Collectors.joining(""));

        return duplicated.length() != input.length();
    }

}
