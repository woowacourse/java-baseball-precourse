package domain;

public class Score {
    private static int THREE_STRIKE = 3;
    private static int ZERO = 0;
    private int ball;
    private int strike;

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
