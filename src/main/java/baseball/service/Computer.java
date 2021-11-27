package baseball.service;

import baseball.domain.BaseBall;

public class Computer {

    BaseBall baseBall = new BaseBall();

    public BaseBall computeScore(int[] gameNumber, int[] userNumber, int size) {
        for (int i = 0; i < size; i++) {
            compute(gameNumber, userNumber, i);
        }
        return baseBall;
    }

    private void compute(int[] gameNumber, int[] userNumber, int index) {
        int temp = -1;
        for (int i = 0; i < gameNumber.length; i++) {
            if (gameNumber[i] == userNumber[index]) {
                temp = i;
                break;
            }
        }
        incCount(index, temp);
    }

    private void incCount(int index, int temp) {
        if (temp != index && temp != -1) {
            baseBall.incBallCount();
        }
        if (temp == index) {
            baseBall.incStrikeCount();
        }
    }
}
