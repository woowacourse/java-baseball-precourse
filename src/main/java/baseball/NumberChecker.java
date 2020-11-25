package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberChecker {

    private static final int BASEBALL_NUMBERS_SIZE = 3;
    private static final int BASEBALL_EACH_NUMBER_MIN = 1;
    private static final int BASEBALL_EACH_NUMBER_MAX = 9;

    public boolean isValidNumbers(List<Integer> numbers) {
        if (!isCorrectRange(numbers) || !isNotDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean isCorrectRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(BASEBALL_EACH_NUMBER_MIN <= number
                && number <= BASEBALL_EACH_NUMBER_MAX)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotDuplicated(List<Integer> numbers) {
        Set<Integer> duplicateRemoved = new HashSet<>(numbers);
        return duplicateRemoved.size() == BASEBALL_NUMBERS_SIZE;
    }
}
