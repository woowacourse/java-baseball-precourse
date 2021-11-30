package baseball.model;

import baseball.util.AnswerRange;

public class Hint {
    private int strike;
    private int ball;

    public Hint() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void compareAnswer(int[] computerAnswer, int[] playerAnswer) {
        initHint();

        for (int i = 0; i < AnswerRange.DIGIT; i++) {
            countStrike(computerAnswer[i], playerAnswer[i]);
            countBall(i, computerAnswer, playerAnswer[i]);
        }
    }

    private void initHint() {
        this.strike = 0;
        this.ball = 0;
    }

    private void countStrike(int computerAnswer, int playerAnswer) {
        if (computerAnswer == playerAnswer) {
            strike++;
        }
    }

    private void countBall(int idx, int[] computerAnswer, int playerAnswer) {
        for (int i = 0; i < AnswerRange.DIGIT; i++) {

            if (idx != i && computerAnswer[i] == playerAnswer) {
                ball++;
                break;
            }
        }
    }
}
