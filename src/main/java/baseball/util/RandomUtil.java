package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    private RandomUtil() {
    }

    public static int[] createComputerNumbers() {
        int[] computerNumbers = new int[3];

        for (int i =0; i < 3; i++) {
            computerNumbers[i] = assignNumber(computerNumbers);
        }

        return computerNumbers;
    }

    private static int assignNumber(int[] computerNumbers) {
        while (true) {
            int randomNumber = getRandomNumber();

            boolean checkContain = checkContains(computerNumbers, randomNumber);

            if(checkContain == true) {
                return randomNumber;
            }
        }
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    private static boolean checkContains(int[] computerNumbers, int randomNumber) {

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == 0) {
                break;
            }
            if (computerNumbers[i] == randomNumber) {
                return false;
            }
        }

        return true;
    }
}
