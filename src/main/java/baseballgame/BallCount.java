package baseballgame;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-11-28
 */
public class BallCount {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final int ZERO = 0;

    private final int strike;
    private final int ball;

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        if (hasStrike() && hasBall()) {
            return String.format("%d %s %d %s", strike, STRIKE, ball, BALL);
        }
        if (hasStrike()) {
            return String.format("%d %s", strike, STRIKE);
        }
        if (hasBall()) {
            return String.format("%d %s", ball, BALL);
        }
        return NOTHING;
    }

    public boolean hasStrike() {
        return strike > ZERO;
    }

    public boolean hasBall() {
        return ball > ZERO;
    }

    public boolean isStrikeOut() {
        return strike == Number.TOTAL_NUMBER;
    }
}
