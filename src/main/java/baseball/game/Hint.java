package baseball.game;

import java.util.List;

public class Hint {
    private int strike;
    private int ball;

    public Hint(){}

    public void countHint(List<Integer> input, List<Integer> answer) {
        strike = 0;
        ball = 0;

        for (int i = 0; i < 3; i++) {
            countStrike(input.get(i), answer.get(i));
            countball(input.get(i), i, answer);
        }
    }

    private void countStrike(int userNum, int answerNum) {
        if (userNum == answerNum) {
            this.strike++;
        }
    }

    private void countball(int userNum, int answerIdx, List<Integer> answer) {
        for (int i = 0; i < 3; i++) {
            if (i != answerIdx && userNum == answer.get(i)) {
                this.ball++;
            }
        }
    }

    public void printResult() {
        if (this.ball == 0 && this.strike == 0) {
            System.out.print("낫싱");
        }
        if (this.ball > 0) {
            System.out.print(this.ball + "볼");
        }
        if (this.strike > 0) {
            System.out.print(this.strike + "스트라이크");
        }
        System.out.println();
    }

    public int getStrike() {
        return this.strike;
    }
}
