package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {

    public static final int ASCII_ZERO = 48;

    private final List<Integer> numbers;

    public BaseballNumbers(String inputNumbers) {
        this.numbers = new ArrayList<>();
        addNumbers(inputNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getNumber(int numberIndex) {
        return numbers.get(numberIndex);
    }

    private void addNumbers(String inputNumbers) {
        inputNumbers.chars()
                .distinct()
                .mapToObj(number -> number - ASCII_ZERO)
                .forEach(numbers::add);
    }

    public boolean isStrike(int numberIndex, int pitchedNumber) {
        return getNumber(numberIndex) == pitchedNumber;
    }

    public boolean isBall(int pitchedNumber) {
        return numbers.contains(pitchedNumber);
    }
}
