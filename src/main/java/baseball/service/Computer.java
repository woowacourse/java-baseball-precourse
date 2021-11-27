package baseball.service;

import baseball.domain.BaseBall;

public class Computer {

    public BaseBall computeScore(int[] gameNumber, int[] userNumber, int size) {
        BaseBall baseBall = new BaseBall();

        for (int i = 0; i < size; i++) {
            compute(baseBall, gameNumber, userNumber, i);
        }
        return baseBall;
    }

    private void compute(BaseBall baseBall, int[] gameNumber, int[] userNumber, int index) {
        int temp = -1;
        for (int i = 0; i < gameNumber.length; i++) {
            if (gameNumber[i] == userNumber[index]) {
                temp = i;
                break;
            }
        }
        incCount(baseBall, index, temp);
    }

    private void incCount(BaseBall baseBall, int index, int temp) {
        if (temp != index && temp != -1) {
            baseBall.incBallCount();
        }
        if (temp == index) {
            baseBall.incStrikeCount();
        }
    }
}
