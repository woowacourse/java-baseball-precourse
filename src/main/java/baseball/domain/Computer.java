package baseball.domain;

import baseball.domain.vo.BallStrikeCount;
import baseball.domain.vo.number.Number;

public class Computer {

    private Number number;

    public Computer(Number number) {
        this.number = number;
    }

    public BallStrikeCount countBallStrike(Number otherNumber) {
        return number.compare(otherNumber);
    }
}
