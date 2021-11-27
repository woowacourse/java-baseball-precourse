package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    private RandomUtil() {
    }

    public static int[] createComputerNumbers() {
        int[] computerNumbers = new int[3];

        for (int i =0; i < 3; i++) {
            computerNumbers[i] = getRandomNumber();
        }

        return computerNumbers;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
