package baseball.domain.vo;

import java.util.Objects;

public class JudgementResult {

    private static final int NOTHING = 0;
    private static final int THREE_STRIKE = 3;
    public static final char WHITE_SPACE = ' ';

    public static final String NOTHING_STRING = "낫싱";
    public static final String STRIKE_COUNT_FORMAT = "%d스트라이크";
    public static final String BALL_COUNT_FORMAT = "%d볼";

    private final int ball;
    private final int strike;

    public JudgementResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
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
            return sb.append(NOTHING_STRING).toString();
        }

        if (!equal(ball, NOTHING)) {
            String ballCount = getBallCountToString();
            sb.append(ballCount).append(WHITE_SPACE);
        }

        if (!equal(strike, NOTHING)) {
            String strikeCount = getStrikeCountToString();
            sb.append(strikeCount);
        }

        return sb.toString().trim();
    }

    private String getStrikeCountToString() {
        return countToStringFormat(STRIKE_COUNT_FORMAT, strike);
    }

    private String getBallCountToString() {
        return countToStringFormat(BALL_COUNT_FORMAT, ball);
    }

    private String countToStringFormat(String format, int count) {
        return String.format(format, count);
    }
}
