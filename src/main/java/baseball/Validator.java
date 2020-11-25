package baseball;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final String START_VALUE = "1";
    private static final String END_VALUE = "2";

    public static void isValidRangeNumber(int value) {
        if (value < 100 || value > 999) {
            throw new IllegalArgumentException();
        }
    }

    public static void isContainZero(int value) {
        if (checkZero(value)) {
            throw new IllegalArgumentException();
        }
    }

    public static void isAnyMatchNumbers(int value) {
        if (checkAnyMatchNumbers(value)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isEqualRestartValue(String value) {
        return value.equals(START_VALUE);
    }

    public static boolean isEqualEndValue(String value) {
        return value.equals(END_VALUE);
    }

    private static boolean checkZero(int value) {
        char[] chars = Integer.toString(value).toCharArray();

        for (char c : chars) {
            if (c == '0') {
                return true;
            }
        }

        return false;
    }

    private static boolean checkAnyMatchNumbers(int number) {
        char[] chars = Integer.toString(number).toCharArray();
        List<Character> values = new ArrayList<>();

        for (char c : chars) {
            if (values.contains(c)) {
                return true;
            }

            values.add(c);
        }

        return false;
    }
}
