package baseball.logic;

public class GameResultObject {
    private Boolean isEnd;
    private int ball;
    private int strike;

    public GameResultObject(Boolean isEnd, int ball, int strike) {
        this.isEnd = isEnd;
        this.ball = ball;
        this.strike = strike;
    }

    public Boolean getIsEnd() {
        return this.isEnd;
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }
}
