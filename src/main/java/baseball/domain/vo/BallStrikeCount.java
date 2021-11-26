package baseball.domain.vo;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isNothing()) {
            return sb.append("낫싱").toString();
        }

        if (!equal(ball, NOTHING)) {
            String ballCount = getBallCountToString();
            sb.append(ballCount).append(' ');
        }

        if (!equal(strike, NOTHING)) {
            String strikeCount = getStrikeCountToString();
            sb.append(strikeCount);
        }

        return sb.toString().trim();
    }

    private String getStrikeCountToString() {
        return countToStringFormat("%d스트라이크", strike);
    }

    private String getBallCountToString() {
        return countToStringFormat("%d볼",ball);
    }

    private String countToStringFormat(String format, int count) {
        return String.format(format, count);
    }
}
