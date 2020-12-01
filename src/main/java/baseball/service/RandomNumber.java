package baseball.service;

import utils.RandomUtils;

public class RandomNumber {

    private RandomNumber() {
    }

    public static final int NUMBER_LENGTH = 3;

    public static int[] makeNumber() {
        int usedNum[] = new int[10];
        int num[] = new int[NUMBER_LENGTH];

        int i = 0;
        while (i < NUMBER_LENGTH) {
            num[i] = RandomUtils.nextInt(1, 9);
            if (usedNum[num[i] - 1] == 0) {
                usedNum[num[i] - 1] += 1;
                i++;
            }
        }

        return num;
    }
}
