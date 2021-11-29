package baseball.game;

import org.mockito.internal.util.StringUtil;

public class BaseballCount {

    private final Strike strike;
    private final Ball ball;

    public BaseballCount(Strike strike, Ball ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        isExistBallCount(sb);
        isExistStrikeCount(sb);
        return sb.toString();
    }

    private void isExistBallCount(StringBuilder sb) {
        if (ball.count > 0) {
            sb.append(ball.count).append("볼").append(" ");
        }
    }

    private void isExistStrikeCount(StringBuilder sb) {
        if (strike.count > 0) {
            sb.append(strike.count).append("스트라이크");
        }
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
