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
        initCount();

        for (int i = 0; i < NUMBER_LEN; i++) {
            countStrike(computerAnswer[i], userAnswer[i]);
            countBall(computerAnswer, userAnswer[i], i);
        }
    }

    private void initCount() {
        this.strike = 0;
        this.ball = 0;
    }

    private void countStrike(int computerNum, int userNum) {
        if (computerNum == userNum) {
            this.strike++;
        }
    }

    private void countBall(int[] computerAnswer, int userNum, int userNumIdx) {
        for (int i = 0; i < NUMBER_LEN; i++) {
            if (i != userNumIdx && computerAnswer[i] == userNum) {
                this.ball++;
            }
        }
    }

    public void printHint() {
        if (this.ball > 0) {
            System.out.print(this.ball + "볼 ");
        }
        if (this.strike > 0) {
            System.out.print(this.strike + "스트라이크 ");
        }
        if (this.ball == 0 && this.strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public int getStrike() {
        return this.strike;
    }
}
