package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class BaseballNumbers {

    public static final String DUPLICATE_NUMBER_MESSAGE = "중복된 값이 입력되었습니다!";

    private final Set<Integer> numbers;

    public BaseballNumbers(String inputNumbers) {
        this.numbers = new HashSet<>();
        addNumbers(inputNumbers);

        if (hasDuplicateNumber()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    public boolean hasDuplicateNumber() {
        return numbers.size() != 3;
    }

    private void addNumbers(String inputNumbers) {
        inputNumbers.chars()
                .mapToObj(number -> (char) number - '0')
                .forEach(numbers::add);
    }
}
