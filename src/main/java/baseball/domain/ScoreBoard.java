package baseball.domain;

public class ScoreBoard {

    private final Count strike;

    private final Count ball;

    public ScoreBoard() {
        this.strike = new Count();
        this.ball = new Count();
    }

    public boolean hasZeroStrike() {
        return strike.isZero();
    }
}
