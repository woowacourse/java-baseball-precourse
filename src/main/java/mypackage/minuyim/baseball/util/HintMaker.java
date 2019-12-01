package mypackage.minuyim.baseball.util;

public class HintMaker {
    private static final int LENGTH_NUMBER = 3;
    public int strike;
    public int ball;
    private int[] ans;
    private int[] user;

    public HintMaker(int[] answer, int[] userAnswer) {
        this.ans = answer;
        this.user = userAnswer;
        this.strike = makeStrike(this.ans, this.user);
        this.ball = makeBall(this.ans, this.user);
    }

    private int makeStrike(int[] answer, int[] userAnswer) {
        int count = 0;

        for (int i = 0; i < LENGTH_NUMBER; i++) {
            count += compareN(answer[i], userAnswer[i]);
        }
        return count;
    }

    private int makeBall(int[] answer, int[] userAnswer) {
        int count = 0;

        for (int i = 0; i < LENGTH_NUMBER; i++) {
            for (int j = 0; j < LENGTH_NUMBER; j++) {
                count += compareN(answer[i], userAnswer[j]);
            }
        }
        return count - makeStrike(answer, userAnswer);
    }

    private int compareN(int num1, int num2) {
        if (num1 == num2) {
            return 1;
        }
        return 0;
    }
}
