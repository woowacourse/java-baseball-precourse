package baseball;

public class Hint {
    private static final int NUMBER_LEN = 3;

    int strike;
    int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void countHint(int[] computerAnswer, int[] userAnswer) {
        for (int i = 0; i < NUMBER_LEN; i++) {
            countStrike(computerAnswer[i], userAnswer[i]);
            countBall(computerAnswer, userAnswer[i], i);
        }
    }

    private void countStrike(int computerNum, int userNum) {
        if (computerNum == userNum) {
            this.strike++;
        }
    }

    private void countBall(int[] computerAnswer, int userNum, int userNumIdx) {

    }
}
