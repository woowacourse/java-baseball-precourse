package utils;

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

    public static String validateInputInProgress(String input, int NumberOfDigits, int minDigit, int maxDigit) {
        if (!ValidationUtils.hasEqualNumberOfDigits(input, NumberOfDigits)) {
            throw new IllegalArgumentException();
        }

        if (!ValidationUtils.isDigits(input, minDigit, maxDigit)) {
            throw new IllegalArgumentException();
        }

        if (ValidationUtils.hasDuplicateDigits(input)) {
            throw new IllegalArgumentException();
        }

        return input;
    }
}
