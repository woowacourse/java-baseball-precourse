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

    public int compareBall(BaseballNumbers baseballNumbers) {
        List<BaseballNumber> otherBaseballNumbers = baseballNumbers.baseballNumbers;
        int ballNumber = 0;
        for (int otherBaseballIndex = 0; otherBaseballIndex < BASEBALL_NUMBERS_LENGTH; otherBaseballIndex++) {
            if (hasBall(otherBaseballIndex, otherBaseballNumbers)) {
                ballNumber++;
            }
        }

        return ballNumber;
    }

    private boolean hasBall(int otherBaseballIndex, List<BaseballNumber> otherBaseballNumbers) {
        for (int thisBaseballIndex = 0; thisBaseballIndex < BASEBALL_NUMBERS_LENGTH; thisBaseballIndex++) {
            if (thisBaseballIndex == otherBaseballIndex) {
                continue;
            }

            if (this.baseballNumbers.get(otherBaseballIndex).equals(otherBaseballNumbers.get(thisBaseballIndex))) {
                return true;
            }
        }

        return false;
    }

    public boolean isEqualTo(BaseballNumbers baseballNumbers) {
        List<BaseballNumber> otherBaseballNumbers = baseballNumbers.baseballNumbers;
        return IntStream.range(0, BASEBALL_NUMBERS_LENGTH)
                .allMatch(index -> this.baseballNumbers.get(index).equals(otherBaseballNumbers.get(index)));
    }
}
