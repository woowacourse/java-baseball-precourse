package baseball.service;

public class Compute {
    public Compute() {
    }

    public int[] computeScore(int[] gameNumber, int[] userNumber, int size) {
        int[] score = {0, 0};

        for (int i = 0; i < size; i++) {
            if (gameNumber[i] != userNumber[i]) {
                score[0]++;
            }
            if (gameNumber[i] == userNumber[i]) {
                score[1]++;
            }
        }
        return score;
    }
}
