package baseball;

public class Hint {
    private int strike;
    private int ball;

    public void countHint(int[] computerAnswer, int[] userAnswer) {
        initCount();

        for (int i = 0; i < Constant.NUMBER_LEN; i++) {
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
        for (int i = 0; i < Constant.NUMBER_LEN; i++) {
            if (i != userNumIdx && computerAnswer[i] == userNum) {
                this.ball++;
            }
        }
    }

    public void printHint() {
        if (this.ball > 0) {
            System.out.print(this.ball + Constant.BALL);
        }
        if (this.strike > 0) {
            System.out.print(this.strike + Constant.STRIKE);
        }
        if (this.ball == 0 && this.strike == 0) {
            System.out.print(Constant.NOTHING);
        }
        System.out.println();
    }

    public int getStrike() {
        return this.strike;
    }
}
