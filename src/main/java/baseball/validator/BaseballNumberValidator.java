package baseball.validator;

import baseball.domain.BaseballNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumberValidator {
    private static final String IS_NOT_THREE_DIGIT = "입력값은 세자리이어야 합니다.";
    private static final String CAN_NOT_CONTAIN_ZERO = "입력값은 0을 포합할 수 없습니다.";
    private static final String CAN_NOT_DUPLICATE = "입력값은 중복된 숫자를 포함할 수 없습니다.";
    private static final int ZERO = 0;

    private BaseballNumberValidator() {
    }

    public static void validateBaseballNumber(List<Integer> numbers) {
        try {
            validateCountOfDigit(numbers);
            validateEachDigitIsNotZero(numbers);
            validateDuplication(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static void validateCountOfDigit(List<Integer> numbers) {
        int countOfDigit = numbers.size();
        if (countOfDigit != BaseballNumber.COUNT_OF_DIGIT) {
            throw new IllegalArgumentException(IS_NOT_THREE_DIGIT);
        }
    }

    private static void validateEachDigitIsNotZero(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateDigitIsNotZero(number);
        }
    }

    private static void validateDigitIsNotZero(int number) {
        if (number == ZERO) {
            throw new IllegalArgumentException(CAN_NOT_CONTAIN_ZERO);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (set.contains(number)) {
                throw new IllegalArgumentException(CAN_NOT_DUPLICATE);
            }
            set.add(number);
        }
    }
}