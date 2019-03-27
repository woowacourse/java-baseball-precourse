package baseball;

public class Validation {

    public static boolean isInputValid(String digits, int length) {
        return (isNotNull(digits)
                && isEqualLength(digits, length)
                && isAllDigitsBetweenOneAndNine(digits)
                && isAllDigitsDifferent(digits, length));
    }

    private static boolean isNotNull(String digits) {
        return digits != null;
    }

    private static boolean isEqualLength(String digits, int length) {
        return digits.length() == length;
    }

    private static boolean isAllDigitsDifferent(String digits, int length) {
        for (int i = 0; i < length - 1; i++) {
            if (digits.lastIndexOf(digits.charAt(i)) != i)
                return false;
        }
        return true;
    }

    private static boolean isAllDigitsBetweenOneAndNine(String digits) {
        for (char digit : digits.toCharArray()) {
            if (digit < '1' || digit > '9')
                return false;
        }
        return true;
    }
}
