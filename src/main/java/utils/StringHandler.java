package utils;

import java.util.Arrays;

public class StringHandler {

    private StringHandler(){}

    public static boolean isInRange(String input, int min, int max) {
        if (!isNumericString(input)) {
            return false;
        }

        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .allMatch(x-> x >= min && x <= max);
    }

    public static boolean isValidLength(String input, int len) {
        return input.length() == len;
    }

    public static boolean isAllDifferent(String input) {
        return Arrays.stream(input.split(""))
                .distinct()
                .count() == input.length();
    }

    private static boolean isNumericString(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException IAE) {
            return false;
        }
        return true;
    }


}
