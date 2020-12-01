package dto;

public class Result {
    private int ball;
    private int strike;

    public Result() {
        ball = 0;
        strike = 0;
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

    @Override
    public String toString() {
        if (ball != 0 && strike != 0) {
            return ball+"볼 "+strike+"스트라이크";
        } else if (ball != 0) {
            return ball+"볼";
        } else if (strike != 0) {
            return strike+"스트라이크";
        } else {
            return "낫싱";
        }
    }
}
