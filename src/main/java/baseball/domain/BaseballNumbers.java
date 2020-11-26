package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {

    public static final String DUPLICATE_NUMBER_MESSAGE = "중복된 값이 입력되었습니다!";

    private final List<Integer> numbers;

    public BaseballNumbers(String inputNumbers) {
        this.numbers = new ArrayList<>();
        addNumbers(inputNumbers);

        if (hasDuplicateNumber()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    public boolean hasDuplicateNumber() {
        return numbers.size() != 3;
    }

    public int getNumber(int numberIndex) {
        return numbers.get(numberIndex);
    }

    private void addNumbers(String inputNumbers) {
        inputNumbers.chars()
                .distinct()
                .mapToObj(number -> (char) number - '0')
                .forEach(numbers::add);
    }
}
