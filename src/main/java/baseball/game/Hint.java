package baseball.game;

import java.util.List;

public class Hint {
    private int strike;
    private int ball;

    public Hint() {
    }

    public void countHint(List<Integer> input, List<Integer> answer) {
        strike = 0;
        ball = 0;

        for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
            countStrike(input.get(i), answer.get(i));
            countball(input.get(i), i, answer);
        }

        printResult();
    }

    private void countStrike(int userNum, int answerNum) {
        if (userNum == answerNum) {
            this.strike++;
        }
    }

    private void countball(int userNum, int answerIdx, List<Integer> answer) {
        for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
            if (i != answerIdx && userNum == answer.get(i)) {
                this.ball++;
            }
        }
    }

    public void printResult() {
        if (this.ball == 0 && this.strike == 0) {
            System.out.print(Constant.NOTHING);
        }
        if (this.ball > 0) {
            System.out.print(this.ball + Constant.BALL);
        }
        if (this.strike > 0) {
            System.out.print(this.strike + Constant.STRIKE);
        }
        System.out.println();
    }

    public boolean isThreeStrike() {
        if (strike == Constant.NUMBER_LENGTH) {
            return true;
        }
        return false;
    }
}
