package baseball;

import baseball.domain.BallStrikeCount;
import baseball.domain.Number;

public class Computer {

    private Number number;

    public Computer(Number number) {
        this.number = number;
    }

    public BallStrikeCount countBallStrike(Number otherNumber) {
        return number.compare(otherNumber);
    }
}
