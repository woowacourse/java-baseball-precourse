package baseball.service;

public class Compute {

    public int[] computeScore(int[] gameNumber, int[] userNumber, int size) {
        int[] score = {0, 0};

        for (int i = 0; i < size; i++) {
            compute(score, gameNumber, userNumber, i);
        }
        return score;
    }

    private void compute(int[] score, int[] gameNumber, int[] userNumber, int index) {
        int temp = -1;
        for (int i = 0; i < gameNumber.length; i++) {
//            System.out.println(gameNumber[i] + " " + userNumber[index]);
            if (gameNumber[i] == userNumber[index]) {
                temp = i;
                break;
            }
        }
        if (temp != index && temp != -1) {
            score[0]++;
        }
        if (temp == index) {
            score[1]++;
        }
    }
}
