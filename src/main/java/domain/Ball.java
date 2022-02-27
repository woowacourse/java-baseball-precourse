package domain;

public class Ball {


    private int ball;

    public Ball(int ball) {
        validateBallCheck(ball);
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    private void validateBallCheck(int ball) {

        // 숫자 0 체크
        // 숫자가 아닌 예외는 Player에서 예외처리
        if (ball == 0) {
            throw new IllegalArgumentException("숫자로 0을 입력할 수 없습니다. 1~9 사이의 숫자를 입력해주세요.");
        }
    }
}
