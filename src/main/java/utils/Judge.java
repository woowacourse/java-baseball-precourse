package utils;


public class Judge {
    private int strike = 0;
    private int ball = 0;

    public void checkNum(int[] answer, int[] input) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                judgeStrike(answer, input, i, j);
                judgeBall(answer, input, i, j);
            }
        }
    }

    public void judgeStrike(int[] answer, int[] input, int targetIndex1, int targetIndex2) {
        if (targetIndex1 == targetIndex2 && answer[targetIndex1] == input[targetIndex2]) {
            strike += 1;
        }
    }

    public void judgeBall(int[] answer, int[] input, int targetIndex1, int targetIndex2) {
        if (targetIndex1 != targetIndex2 && answer[targetIndex1] == input[targetIndex2]) {
            ball += 1;
        }
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

}
