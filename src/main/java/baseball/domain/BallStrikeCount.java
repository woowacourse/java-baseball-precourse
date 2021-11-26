package baseball.domain;

import java.util.Objects;

public class BallStrikeCount {

    private static final int NOTHING = 0;
    private static final int THREE_STRIKE = 3;

    int ball;
    int strike;

    private BallStrikeCount(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static BallStrikeCount threeStrike() {
        return new BallStrikeCount(NOTHING, THREE_STRIKE);
    }

    public static BallStrikeCount nothing() {
        return new BallStrikeCount(NOTHING, NOTHING);
    }

    public static BallStrikeCount newInstance(int ballCount, int strikeCount) {
        return new BallStrikeCount(ballCount, strikeCount);
    }

    public boolean isThreeStrike() {
        return equal(strike, THREE_STRIKE);
    }

    public boolean isNothing() {
        return equal(ball, NOTHING) && equal(strike, NOTHING);
    }

    private boolean equal(int count, int otherCount) {
        return Objects.equals(count, otherCount);
    }
}
