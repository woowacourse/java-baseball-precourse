package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Number {

    public static final String DIGIT_VALIDATION_ERROR_MESSAGE = "세 자리수 정수가 아닙니다.";
    public static final String DUPLICATION_VALIDATION_ERROR_MESSAGE = "중복인 수가 존재합니다.";
    public static final int MIN_NUMBER = 100;
    public static final int MAX_NUMBER = 999;
    public static final int DIGIT_NUMBER_CONDITION = 3;

    private Integer value;

    Number() {}

    public Number(Integer value) {
        validate(value);
        this.value = value;
    }

    private void validate(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(DIGIT_VALIDATION_ERROR_MESSAGE);
        }

        if (Arrays.stream(number.toString().split(""))
                .distinct()
                .count() != DIGIT_NUMBER_CONDITION
        ) {
            throw new IllegalArgumentException(DUPLICATION_VALIDATION_ERROR_MESSAGE);
        }
    }

    void setValue(Integer value) {
        validate(value);
        this.value = value;
    }

    public List<Integer> fetchDigits() {
        return Arrays.stream(value.toString().split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
