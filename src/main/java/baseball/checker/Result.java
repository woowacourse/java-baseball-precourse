package baseball.checker;

import static baseball.checker.NumberChecker.*;

public class Result {
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private int strike;
    private int ball;

    public Result() {
        this.strike = 0;
        this.ball = 0;
    }

    public void strike() {
        strike++;
    }

    public void ball() {
        ball++;
    }

    public boolean isAnswer() {
        if (strike == BASEBALL_NUMBERS_SIZE) {
            clear();
            return true;
        }
        return false;
    }

    public void printResult() {
        if (ball > 0) {
            System.out.print(ball + BALL_MESSAGE);
        }
        if (ball > 0 && strike > 0) {
            System.out.print(' ');
        }
        if (strike > 0) {
            System.out.print(strike + STRIKE_MESSAGE);
        }
        if (ball == 0 && strike == 0) {
            System.out.print(NOTHING_MESSAGE);
        }
        System.out.println();
    }

    public void clear() {
        strike = 0;
        ball = 0;
    }
}
