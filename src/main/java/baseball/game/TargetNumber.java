package baseball.game;

import baseball.utils.GameValidator;
import java.util.List;

public class TargetNumber {

    private final List<Integer> numbers;

    public TargetNumber(List<Integer> numbers) {
        GameValidator.validateRange(numbers);
        GameValidator.validateSize(numbers);
        GameValidator.validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public boolean isStrike(int position, int number) {
        return this.numbers.get(position) == number;
    }

    public boolean isBall(int position, int number) {
        return this.numbers.contains(number) && !isStrike(position, number);
    }
}
