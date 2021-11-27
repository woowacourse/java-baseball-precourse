package baseball;

import java.util.Arrays;

public class Validation {

    public static void isValidInput(String input) {
        if (isValidLength(input) && isValidNumber(input) && isDuplicated(input)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private static boolean isValidNumber(String input) {
        char[] arr = input.toCharArray();
        for (char c : arr) {
            if (c - '0' < Constant.MIN_VALUE || c - '0' > Constant.MAX_VALUE) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidLength(String input) {
        return (input.length() == Constant.NUMBER_OF_NUMBERS);
    }

    private static boolean isDuplicated(String input) {
        boolean[] check = new boolean[Constant.MAX_VALUE + 1];
        char[] arr = input.toCharArray();

        Arrays.fill(check, false);

        for (char c : arr) {
            if (check[c - '0']) {
                return false;
            }
            check[c - '0'] = true;
        }
        return true;
    }

}
