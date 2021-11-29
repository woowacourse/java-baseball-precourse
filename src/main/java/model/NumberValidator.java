package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class NumberValidator {
    private static final String INTEGER_REGEX = "^[0-9]*$";

    private NumberValidator() {
    }

    public static List<Integer> getValidatedNumbers(String[] tokens) {
        validate(tokens);
        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validate(String[] tokens) {
        if (Arrays.stream(tokens).anyMatch(NumberValidator::isNotInteger)) {
            throw new IllegalArgumentException("정수만 입력하셔야합니다.");
        }
    }

    private static boolean isNotInteger(String value) {
        return !value.matches(INTEGER_REGEX);
    }
}
