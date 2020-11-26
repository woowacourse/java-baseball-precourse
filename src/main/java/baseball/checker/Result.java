package baseball.checker;

import static baseball.checker.NumberChecker.*;

public class Result {
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
        return strike == BASEBALL_NUMBERS_SIZE;
    }

    public void printResult() {
        if (ball > 0) {
            System.out.print(ball + "볼");
        }
        if (ball > 0 && strike > 0) {
            System.out.print(' ');
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public void clearResult() {
        strike = 0;
        ball = 0;
    }
}
