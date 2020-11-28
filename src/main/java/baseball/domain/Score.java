package baseball.domain;

public class Score {
    private static final int THREE_STRIKE = 3;
    private static final int ZERO = 0;

    private final int ball;
    private final int strike;

    public Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isThreeStrike() {
        return strike == THREE_STRIKE;
    }

    public boolean isNothing() {
        return ball == ZERO && strike == ZERO;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
