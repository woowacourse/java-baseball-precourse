package baseball.checker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberChecker {
    public static final int NUMBERS_SIZE = 3;
    private static final int DIGIT_MIN_NUMBER = 1;
    private static final int DIGIT_MAX_NUMBER = 9;

    public static void checkNumbers(List<Integer> numbers) {
        checkNumberSize(numbers);
        checkAllDigits(numbers);
        checkNotDuplicated(numbers);
    }

    private static void checkNumberSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkAllDigits(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkDigit(number);
        }
    }

    private static void checkDigit(Integer number) {
        if (!(DIGIT_MIN_NUMBER <= number && number <= DIGIT_MAX_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNotDuplicated(List<Integer> numbers) {
        Set<Integer> duplicateRemoved = new HashSet<>(numbers);
        if (!(duplicateRemoved.size() == NUMBERS_SIZE)) {
            throw new IllegalArgumentException();
        }
    }
}
