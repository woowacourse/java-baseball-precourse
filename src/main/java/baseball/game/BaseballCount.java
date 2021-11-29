package baseball.game;

public class BaseballCount {

    private final Strike strike;
    private final Ball ball;

    public BaseballCount(Strike strike, Ball ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static class Strike {
        private final int strike;

        public Strike(int strike) {
            this.strike = strike;
        }

        public static Strike of(int strike) {
            return new Strike(strike);
        }

    }

    public static class Ball {
        private final int ball;

        public Ball(int ball) {
            this.ball = ball;
        }

        public static Ball of(int ball) {
            return new Ball(ball);
        }

    }

}
