package baseball.game;

import baseball.NumbersConstraints;
import baseball.utils.NumberListGenerator;

public class BaseballGameRunner {

    private final TargetNumber targetNumber;

    public BaseballGameRunner() {
        this.targetNumber = new TargetNumber(
            NumberListGenerator.generateNonDuplicateNumbers(
                NumbersConstraints.NUMBER_LENGTH.value(),
                NumbersConstraints.MIN_NUMBER.value(),
                NumbersConstraints.MAX_NUMBER.value()
        ));
    }
}
