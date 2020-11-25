package validator;

import java.util.HashSet;
import java.util.Set;

public class ThreeDigitNumberValidator {
    private static final int COUNT_OF_DIGIT = 3;
    private static final char ZERO = '0';
    private static final String IS_NOT_NUMERIC = "입력값은 숫자이어야 합니다.";
    private static final String IS_NOT_POSITIVE = "입력값은 양수이어야 합니다.";
    private static final String IS_NOT_THREE_DIGIT = "입력값은 세자리이어야 합니다.";
    private static final String CAN_NOT_CONTAIN_ZERO = "입력값은 0을 포합할 수 없습니다.";
    private static final String CAN_NOT_DUPLICATE = "입력값은 중복된 숫자를 포함할 수 없습니다.";

    private ThreeDigitNumberValidator() {
    }

    public static boolean validateThreeDigitNumber(String threeDigitNumber) {
        try {
            validateInputIsNumeric(threeDigitNumber);
            validateInputIsPositive(threeDigitNumber);
            validateCountOfDigit(threeDigitNumber);
            validateEachDigitIsNotZero(threeDigitNumber);
            validateDuplication(threeDigitNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return true;
    }

    private static void validateInputIsNumeric(String threeDigitNumber) {
        try {
            Integer.parseInt(threeDigitNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(IS_NOT_NUMERIC);
        }
    }

    private static void validateInputIsPositive(String threeDigitNumber) {
        if (Integer.parseInt(threeDigitNumber) < 0) {
            throw new IllegalArgumentException(IS_NOT_POSITIVE);
        }
    }

    private static void validateCountOfDigit(String threeDigitNumber) {
        int countOfDigit = threeDigitNumber.length();
        if (countOfDigit != COUNT_OF_DIGIT) {
            throw new IllegalArgumentException(IS_NOT_THREE_DIGIT);
        }
    }

    private static void validateEachDigitIsNotZero(String threeDigitNumber) {
        for (int idx = 0; idx < threeDigitNumber.length(); idx++) {
            validateDigitIsNotZero(threeDigitNumber.charAt(idx));
        }
    }

    private static void validateDigitIsNotZero(char digit) {
        if (digit == ZERO) {
            throw new IllegalArgumentException(CAN_NOT_CONTAIN_ZERO);
        }
    }

    private static void validateDuplication(String threeDigitNumber) {
        Set<Character> numbers = new HashSet<>();
        for (int idx = 0; idx < threeDigitNumber.length(); idx++) {
            char number = threeDigitNumber.charAt(idx);
            if (numbers.contains(number)) {
                throw new IllegalArgumentException(CAN_NOT_DUPLICATE);
            }
            numbers.add(number);
        }
    }
}