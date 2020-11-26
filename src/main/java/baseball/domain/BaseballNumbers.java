package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class BaseballNumbers {

    private final Set<Integer> numbers;

    public BaseballNumbers(String inputNumbers) {
        this.numbers = new HashSet<>();
        addNumbers(inputNumbers);
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
