package controller.domain;

public class BaseballStatusImpl implements BaseballStatus {

    private static final int FULL = 3;

    private int ball;
    private int strike;

    @Override
    public int getBall() {
        return this.ball;
    }

    @Override
    public int getStrike() {
        return this.strike;
    }

    @Override
    public void setBall(int ball) {
        this.ball = ball;
    }

    @Override
    public boolean isCorrect() {
        return this.strike == FULL;
    }

    @Override
    public void setStrike(int strike) {
        this.strike = strike;
    }
}
