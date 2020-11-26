package domain;

import validator.BaseballNumberValidator;

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
}
