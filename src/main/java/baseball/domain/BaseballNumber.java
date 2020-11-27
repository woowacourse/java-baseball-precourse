package baseball.domain;

import baseball.validator.BaseballNumberValidator;

import java.util.List;

public class BaseballNumber {
    public static final int COUNT_OF_DIGIT = 3;
    public static final int MIN_OF_NUMBER = 1;
    public static final int MAX_OF_NUMBER = 9;

    private final List<Integer> numbers;

    public BaseballNumber(List<Integer> numbers) {
        BaseballNumberValidator.validateBaseballNumber(numbers);
        this.numbers = numbers;
    }

    public boolean isStrike(BaseballNumber baseballNumber, int idx) {
        return numbers.get(idx).equals(baseballNumber.numbers.get(idx));
    }

    public boolean isBall(BaseballNumber baseballNumber, int idx) {
        return baseballNumber.numbers.contains(numbers.get(idx));
    }
}
