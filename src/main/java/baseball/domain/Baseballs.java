package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public final class Baseballs {

    private static final int ASCII_ZERO = 48;

    private final List<Integer> numbers;

    public Baseballs(final String inputNumbers) {
        this.numbers = new ArrayList<>();
        addNumbers(inputNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getNumber(final int numberIndex) {
        return numbers.get(numberIndex);
    }

    private void addNumbers(final String inputNumbers) {
        inputNumbers.chars()
                .mapToObj(number -> number - ASCII_ZERO)
                .forEach(numbers::add);
    }

    public boolean isStrike(final int numberIndex, final int pitchedNumber) {
        return getNumber(numberIndex) == pitchedNumber;
    }

    public boolean isBall(final int pitchedNumber) {
        return numbers.contains(pitchedNumber);
    }
}
