package baseball.domain;

public class ScoreBoard {

    private final Count strike;

    private final Count ball;

    public ScoreBoard() {
        this(0, 0);
    }

    public ScoreBoard(int strike, int ball) {
        this.strike = new Count(strike);
        this.ball = new Count(ball);
    }

    public void recordStrike() {
        strike.increaseCount();
    }

    public void recordBall() {
        ball.increaseCount();
    }

    public boolean hasZeroStrike() {
        return strike.isZero();
    }

    public boolean hasZeroBall() {
        return ball.isZero();
    }

    public boolean isAnswer() {
        return strike.equals(3);
    }
}
