package baseball.model;

import baseball.constant.Constants;

public class Record {
    private int ball;
    private int strike;

    public Record() {
        this(0, 0);
    }

    public Record(int ball, int strike) {

        if (ball < Constants.VALUE_ZERO
                || ball > Constants.ANSWER_LENGTH
                || strike < Constants.VALUE_ZERO
                || strike > Constants.ANSWER_LENGTH) {
            throw new IllegalArgumentException();
        }

        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }
}
