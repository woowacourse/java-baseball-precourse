package model;

import java.util.List;

public class BallCount {
    private final int strike;
    private final int ball;

    public BallCount(final List<ComparisonResult> result) {
        this.strike = (int) result.stream()
                .filter(comparisonResult -> comparisonResult == ComparisonResult.STRIKE)
                .count();
        this.ball = (int) result.stream()
                .filter(comparisonResult -> comparisonResult == ComparisonResult.BALL)
                .count();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
