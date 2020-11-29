package baseball;

public class Hint {
    private static final int MAX_STRIKE_COUNT = 3;
    private static final int ZERO = 0;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private final int ball;
    private final int strike;

    public Hint(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean checkStrikeAll() {
        return strike == MAX_STRIKE_COUNT;
    }

    public String toMessage() {
        if (ball == ZERO && strike ==ZERO) {
            return NOTHING;
        }
        if (ball == ZERO) {
            return String.format("%d%s", strike, STRIKE);
        }
        if (strike == ZERO) {
            return String.format("%d%s", ball, BALL);
        }
        return String.format("%d%s %d%s", ball, BALL, strike, STRIKE);
    }
}
