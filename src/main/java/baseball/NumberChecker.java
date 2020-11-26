package baseball;

import static baseball.CheckerType.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberChecker {
    public static final int BASEBALL_NUMBERS_SIZE = 3;
    private static final int BASEBALL_EACH_NUMBER_MIN = 1;
    private static final int BASEBALL_EACH_NUMBER_MAX = 9;

    public static boolean isValidNumbers(List<Integer> numbers, CheckerType checkerType) {
        if (numbers.size() != 3 || !isCorrectRange(numbers) || !isNotDuplicated(numbers)) {
            if (checkerType == USER) {
                throw new IllegalArgumentException();
            }
            if (checkerType == COMPUTER) {
                // System.out.println("컴퓨터의 번호가 유효하지 않음 : " + numbers.toString());
                return false;
            }
        }
        return true;
    }

    private static boolean isCorrectRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(BASEBALL_EACH_NUMBER_MIN <= number
                && number <= BASEBALL_EACH_NUMBER_MAX)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNotDuplicated(List<Integer> numbers) {
        Set<Integer> duplicateRemoved = new HashSet<>(numbers);
        return duplicateRemoved.size() == BASEBALL_NUMBERS_SIZE;
    }
}
