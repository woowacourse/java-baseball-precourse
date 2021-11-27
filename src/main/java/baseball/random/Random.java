package baseball.random;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    public int[] createComputerNumbers() {
        int[] computerNumbers = new int[3];

        for (int i =0; i < 3; i++) {
            computerNumbers[i] = getRandomNumber();
        }

        return computerNumbers;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
