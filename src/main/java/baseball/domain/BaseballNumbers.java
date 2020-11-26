package baseball.domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballNumbers {
    private static final String INPUT_BASEBALL_NUMBER_DUPLICATION_ERROR_MESSAGE = "중복되지 않는 숫자를 입력해주세요.";
    private static final int BASEBALL_NUMBERS_LENGTH = 3;
    private static final String INPUT_BASEBALL_NUMBERS_IS_NOT_BASEBALL_NUMBERS_LENGTH_ERROR_MESSAGE = "자리의 숫자만 입력할 수 있습니다. ";

    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateBaseballNumbers(baseballNumbers);
        this.baseballNumbers = new ArrayList<>(baseballNumbers);
    }

    public static BaseballNumbers createAnswerBaseballNumbers() {
        List<Integer> distinctBaseballNumbers = new ArrayList<>();
        while (distinctBaseballNumbers.size() < BASEBALL_NUMBERS_LENGTH) {
            int newBaseballNumber = RandomUtils.nextInt(BaseballNumber.MIN_BASEBALL_NUMBER,
                    BaseballNumber.MAX_BASEBALL_NUMBER);
            if (distinctBaseballNumbers.contains(newBaseballNumber)) {
                continue;
            }

            distinctBaseballNumbers.add(newBaseballNumber);
        }

        List<BaseballNumber> baseballNumbers = distinctBaseballNumbers.stream()
                .map(Integer::new)
                .map(BaseballNumber::new)
                .collect(Collectors.toList());

        return new BaseballNumbers(baseballNumbers);
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
}
