package baseball;

public class Hint {
    private int strike;
    private int ball;

    public void countHint(int[] answer, int[] userNumber) {
        initCount();

        for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
            countStrike(answer[i], userNumber[i]);
            countBall(answer, userNumber[i], i);
        }
    }

    private void initCount() {
        this.strike = 0;
        this.ball = 0;
    }

    private void countStrike(int computer, int user) {
        if (computer == user) {
            this.strike++;
        }
    }

    private void countBall(int[] answer, int user, int userIdx) {
        for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
            if (i != userIdx && answer[i] == user) {
                this.ball++;
            }
        }
    }

    public void printResult() {
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
