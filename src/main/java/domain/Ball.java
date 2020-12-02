package domain;

public class Ball {
    private int ball;

    public Ball(int ball) {
        validateIfNumberIsNotZero(ball);
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    private void validateIfNumberIsNotZero(int ball) {
        if (ball == 0) {
            throw new IllegalArgumentException("숫자로 0을 입력하실 수 없습니다. 1 ~ 9의 숫자만 입력해야 합니다.");
        }
    }
}
