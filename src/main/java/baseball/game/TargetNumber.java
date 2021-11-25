package baseball.game;

import baseball.NumbersConstraints;
import java.util.HashSet;
import java.util.List;

public class TargetNumber {

    private final List<Integer> numbers;

    public TargetNumber(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != NumbersConstraints.NUMBER_LENGTH.value()) {
            throw new IllegalArgumentException("wrong size");
        }
    }

    public void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("number is duplicated");
        }
    }

}
