package baseball;

import static baseball.NumberChecker.*;

public class Result {
    private int strikeNumber;
    private int ballNumber;

    public Result() {
        this.strikeNumber = 0;
        this.ballNumber = 0;
    }

    public void strike() {
        strikeNumber++;
    }

    public void ball() {
        ballNumber++;
    }

    public boolean isAnswer() {
        return strikeNumber == BASEBALL_NUMBERS_SIZE;
    }

    public void printResult() {
        if (ballNumber > 0) {
            System.out.print(ballNumber + "볼");
        }
        if (ballNumber > 0 && strikeNumber > 0) {
            System.out.print(' ');
        }
        if (strikeNumber > 0) {
            System.out.print(strikeNumber + "스트라이크");
        }
        if (ballNumber == 0 && strikeNumber == 0) {
            System.out.print("낫싱");
        }
        System.out.println("");
    }

    public void clearResult() {
        strikeNumber = 0;
        ballNumber = 0;
    }
}
