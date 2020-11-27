package utils;

import java.util.ArrayList;
import java.util.List;

public class InputUtils {

    private InputUtils() {

    }

    public static boolean isDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isInputLengthEqualsToBaseballLength(String input) {
        return input.length() == BaseballDigitsGenerator.BASEBALL_LEN;
    }

    public static boolean isDigitInBaseballRange(String input) {
        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';

            if (digit <= 0 || digit > 9) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDigitInMenuRange(String input) {
        int inputDigit = Integer.parseInt(input);

        if (inputDigit != 1 && inputDigit != 2) {
            return false;
        }

        return true;
    }

    public static List<Integer> convertStringToIntegerList(String input) {
        List<Integer> answer = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            int digit = ch - '0';
            answer.add(digit);
        }

        return answer;
    }
}
