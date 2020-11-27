package baseball.checker;

import static baseball.checker.NumberChecker.*;

public class Result {
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private int strikeCount;
    private int ballCount;

    public Result() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void strike() {
        strikeCount++;
    }

    public void ball() {
        ballCount++;
    }

    public boolean isAnswer() {
        if (strikeCount == NUMBERS_SIZE) {
            clear();
            return true;
        }
        return false;
    }

    public void printResult() {
        if (ballCount > 0) {
            System.out.print(ballCount + BALL_MESSAGE);
        }
        if (ballCount > 0 && strikeCount > 0) {
            System.out.print(' ');
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + STRIKE_MESSAGE);
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print(NOTHING_MESSAGE);
        }
        System.out.println();
    }

    public void clear() {
        strikeCount = 0;
        ballCount = 0;
    }
}
