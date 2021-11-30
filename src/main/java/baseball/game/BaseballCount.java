package baseball.game;

import baseball.util.Assertion;
import java.util.Objects;

public class BaseballCount {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String BLANK = " ";
    private static final int EMPTY = 0;
    private static final int WIN = 3;

    private final Strike strike;
    private final Ball ball;

    public BaseballCount(Strike strike, Ball ball) {
        Assertion.throwExceptionIsNull(Objects.isNull(strike));
        Assertion.throwExceptionIsNull(Objects.isNull(ball));
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        isExistBallCount(sb);
        isExistStrikeCount(sb);
        isEmptyResult(sb);
        return sb.toString();
    }

    private void isExistBallCount(StringBuilder sb) {
        if (ball.count > 0) {
            sb.append(ball.count).append(BALL).append(BLANK);
        }
    }

    private void isExistStrikeCount(StringBuilder sb) {
        if (strike.count > 0) {
            sb.append(strike.count).append(STRIKE);
        }
    }

    private void isEmptyResult(StringBuilder sb) {
        if (sb.length() == EMPTY) {
            sb.append(NOTHING);
        }
    }

    public boolean isWin() {
        return strike.count == WIN;
    }

    public static class Strike {
        private final int count;

        public Strike(int count) {
            this.count = count;
        }

        public static Strike of(int strike) {
            return new Strike(strike);
        }
    }

    public static class Ball {
        private final int count;

        public Ball(int count) {
            this.count = count;
        }

        public static Ball of(int ball) {
            return new Ball(ball);
        }
    }
}
