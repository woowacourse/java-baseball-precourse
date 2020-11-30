package utils;

import baseball.model.ParameterSet;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {
    private ValidationUtils() {
    }

    public static boolean hasEqualNumberOfDigits(String input, int NumberOfDigits) {
        return input.length() == NumberOfDigits;
    }

    public static boolean isDigit(char input, int minDigit, int maxDigit) {
        int convertedToInt = input - '0';
        return convertedToInt >= minDigit && convertedToInt <= maxDigit;
    }

    public static boolean isDigits(String input, int minDigit, int maxDigit) {
        for (char in : input.toCharArray()) {
            if (!ValidationUtils.isDigit(in, minDigit, maxDigit)) {
                return false;
            }
        }

        return true;
    }

    public static boolean hasDuplicateDigits(String input) {
        Set<Character> digitSet = new HashSet<Character>();

        for (char in : input.toCharArray()) {
            if (!digitSet.add(in)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isEitherOneOf(String input, String option1, String option2) {
        return input.equals(option1) || input.equals(option2);
    }

    public static String validateInputInProgress(String input, ParameterSet parameterSet) {
        if (!ValidationUtils.hasEqualNumberOfDigits(input, parameterSet.numberOfDigits())) {
            throw new IllegalArgumentException();
        }

        if (!ValidationUtils.isDigits(input, parameterSet.minDigit(), parameterSet.maxDigit())) {
            throw new IllegalArgumentException();
        }

        if (ValidationUtils.hasDuplicateDigits(input)) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    public static String validateInputAfterEnd(String input, String option1, String option2) {
        if (!ValidationUtils.isEitherOneOf(input, option1, option2)) {
            throw new IllegalArgumentException();
        }

        return input;
    }
}
