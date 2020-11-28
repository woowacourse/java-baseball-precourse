package baseball.domain;

import baseball.BaseballGame;

public class ScoreBoard {

    private final Count strike;

    private final Count ball;

    public ScoreBoard() {
        this(0, 0);
    }

    public ScoreBoard(final int strike, final int ball) {
        this.strike = new Count(strike);
        this.ball = new Count(ball);
    }

    public int getStrike() {
        return strike.getCount();
    }

    public int getBall() {
        return ball.getCount();
    }

    public void record(final Judgment judgment) {
        if (judgment.equals(Judgment.STRIKE)) {
            strike.increaseCount();
        } else if (judgment.equals(Judgment.BALL)) {
            ball.increaseCount();
        }
    }

    public boolean hasZeroStrike() {
        return strike.isZero();
    }

    public boolean hasZeroBall() {
        return ball.isZero();
    }

    public boolean isAnswer() {
        return strike.equals(BaseballGame.BALLS_LENGTH);
    }
}
