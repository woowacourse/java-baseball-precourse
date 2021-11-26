package baseball.game;

import baseball.utils.GameValidator;
import java.util.List;

public class UserExpectation {

    final private List<Integer> numbers;

    public UserExpectation(List<Integer> numbers) {
        GameValidator.validateSize(numbers);
        GameValidator.validateRange(numbers);
        this.numbers = numbers;
    }

    public int getNumberInPosition(int i) {
        return this.numbers.get(i);
    }
}
