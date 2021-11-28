package baseball.domain.number;

import baseball.exception.number.BaseBallNumbersDuplicateException;
import baseball.exception.number.BaseBallNumbersInputSizeException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return (int) IntStream.range(0, BASEBALL_NUMBERS_LIMIT_SIZE)
            .filter(index -> isStrike(index, baseBallNumbers))
            .count();
    }

    private boolean isStrike(int index, BaseBallNumbers baseBallNumbers) {
        return this.numbers.get(index).equals(baseBallNumbers.numbers.get(index));
    }

    public int calculateBallCounts(BaseBallNumbers baseBallNumbers) {
        return (int) IntStream.range(0, BASEBALL_NUMBERS_LIMIT_SIZE)
            .filter(index -> isBall(index, baseBallNumbers))
            .count();
    }

    private boolean isBall(int index, BaseBallNumbers baseBallNumbers) {
        if (isStrike(index, baseBallNumbers)) {
            return false;
        }
        return this.numbers.contains(baseBallNumbers.numbers.get(index));
    }
}
