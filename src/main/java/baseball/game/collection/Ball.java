package baseball.game.collection;

public class Ball {
    private final int ball;

    public Ball(int ball) {
        if (ball < 1 || ball >= 10) {
            throw new IllegalArgumentException();
        }
        this.ball = ball;
    }
}
