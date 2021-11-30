package baseball.domain.vo;

public class Point {
    private int strike;
    private int ball;

    public Point(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}