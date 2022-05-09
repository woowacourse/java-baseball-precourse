package domain;

import java.util.List;

public class Computer {

    private int strike;
    private int ball;
    private int[] coumputerNum;

    public void initBallCount() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int[] getCoumputerNum() {
        return coumputerNum;
    }

    public void setCoumputerNum(int[] coumputerNum) {
        this.coumputerNum = coumputerNum;
    }
}
