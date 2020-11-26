package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class BaseballNumbers {
    public static final int BASEBALL_NUMBERS_LENGTH = 3;
    private static final String INPUT_BASEBALL_NUMBER_DUPLICATION_ERROR_MESSAGE = "중복되지 않는 숫자를 입력해주세요.";
    private static final String INPUT_BASEBALL_NUMBERS_IS_NOT_BASEBALL_NUMBERS_LENGTH_ERROR_MESSAGE = "자리의 숫자만 입력할 수 있습니다. ";

    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateBaseballNumbers(baseballNumbers);
        this.baseballNumbers = new ArrayList<>(baseballNumbers);
    }

    public static BaseballNumbers createAnswerBaseballNumbers(BaseballNumbersGenerator baseballNumbersGenerator) {
        return new BaseballNumbers(baseballNumbersGenerator.generateBaseballNumbers());
    }

    private void validateBaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateBaseballNumbersLength(baseballNumbers);
        validateBaseballNumbersDuplication(baseballNumbers);
    }

    private void validateBaseballNumbersLength(List<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != BASEBALL_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(BASEBALL_NUMBERS_LENGTH
                    + INPUT_BASEBALL_NUMBERS_IS_NOT_BASEBALL_NUMBERS_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateBaseballNumbersDuplication(List<BaseballNumber> baseballNumbers) {
        Set<BaseballNumber> distinctBaseballNumbers = new HashSet<>(baseballNumbers);
        if (distinctBaseballNumbers.size() != BASEBALL_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(INPUT_BASEBALL_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }

    public int compareStrike(BaseballNumbers baseballNumbers) {
        List<BaseballNumber> otherBaseballNumbers = baseballNumbers.baseballNumbers;
        return (int) IntStream.range(0, BASEBALL_NUMBERS_LENGTH)
                .filter(index -> this.baseballNumbers.get(index).equals(otherBaseballNumbers.get(index)))
                .count();
    }
}
