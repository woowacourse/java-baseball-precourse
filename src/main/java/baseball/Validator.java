package baseball;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final String START_VALUE = "1";
    private static final String END_VALUE = "2";
    private static final char ZERO = '0';
    private static final String invalidRangeNumberMessage = "3자리의 수를 입력하세요.";
    private static final String doNotContainZeroMessage = "'0'은 사용할 수 없습니다.";
    private static final String doNotContainMatchNumberMessage = "중복된 숫자는 사용수 없습니다.";
    private static final String invalidValueMessage = "'1' 혹은 '2'의 값을 입력하세요.";

    public static void isValidRangeNumber(int value) {
        if (value < 100 || value > 999) {
            throw new IllegalArgumentException(invalidRangeNumberMessage);
        }
    }

    public static void isContainZero(int value) {
        if (checkZero(value)) {
            throw new IllegalArgumentException(doNotContainZeroMessage);
        }
    }

    public static void isAnyMatchNumbers(int value) {
        if (checkAnyMatchNumbers(value)) {
            throw new IllegalArgumentException(doNotContainMatchNumberMessage);
        }
    }

    public static void isNotMenuValue(String value) {
        if (!(isEqualRestartValue(value) || isEqualEndValue(value))) {
            throw new IllegalArgumentException(invalidValueMessage);
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
            if (c == ZERO) {
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
