package baseball;

public class Hint {
    private static final int MAX_STRIKE_COUNT = 3;
    private int ball;
    private int strike;

    public Hint(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean checkStrikeAll() {
        return strike == MAX_STRIKE_COUNT;
    }
}
