package baseball.domain.number;

import baseball.exception.number.BaseBallNumbersDuplicateException;
import baseball.exception.number.BaseBallNumbersInputSizeException;
import java.util.List;
import java.util.stream.Collectors;

public class BaseBallNumbers {

    public static final int BASEBALL_NUMBERS_LIMIT_SIZE = 3;

    private final List<BaseBallNumber> numbers;

    private BaseBallNumbers(List<BaseBallNumber> numbers) {
        this.numbers = numbers;
    }

    public static BaseBallNumbers createByIntegerNumbers(List<Integer> inputNumbers) {
        checkInputSize(inputNumbers.size());
        checkDuplicatedNumbers(inputNumbers);

        List<BaseBallNumber> baseBallNumbers = integerToBaseBallNumber(inputNumbers);
        return new BaseBallNumbers(baseBallNumbers);
    }

    private static void checkInputSize(int size) {
        if (size > BASEBALL_NUMBERS_LIMIT_SIZE) {
            throw new BaseBallNumbersInputSizeException();
        }
    }

    private static void checkDuplicatedNumbers(List<Integer> inputNumbers) {
        if (calculateDistinctCount(inputNumbers) != BASEBALL_NUMBERS_LIMIT_SIZE) {
            throw new BaseBallNumbersDuplicateException();
        }
    }

    private static long calculateDistinctCount(List<Integer> inputNumbers) {
        return inputNumbers.stream()
            .distinct()
            .count();
    }

    private static List<BaseBallNumber> integerToBaseBallNumber(List<Integer> inputNumbers) {
        return inputNumbers.stream()
            .map(BaseBallNumber::from)
            .collect(Collectors.toList());
    }

    public int calculateStrikeCounts(BaseBallNumbers baseBallNumbers) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (baseBallNumbers.numbers.get(i).equals(this.numbers.get(i))) {
                result++;
            }
        }
        return result;
    }
}
