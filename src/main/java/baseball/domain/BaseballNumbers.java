package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {

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
                .mapToObj(number -> (char) number - '0')
                .forEach(numbers::add);
    }

    public boolean isStrike(int numberIndex, int pitchedNumber) {
        return getNumber(numberIndex) == pitchedNumber;
    }

    public boolean isBall(int pitchedNumber) {
        return numbers.contains(pitchedNumber);
    }
}
