package baseball.service;

import utils.RandomUtils;

public class Number {

    private Number() {
    }

    public static final int NUMBER_LENGTH = 3;

    public static int[] checkValidation(int number) {
        int[] usedNum = new int[10];
        int numArr[] = new int[NUMBER_LENGTH];
        int numLength = 0;

        while (number > 0) {
            int num = (number % 10);
            if (usedNum[num] != 0) {
                throw new IllegalArgumentException();
            }
            usedNum[num] = 1;
            number /= 10;
            numLength++;
        }

        if (numLength != NUMBER_LENGTH || usedNum[0] != 0) {
            throw new IllegalArgumentException();
        }

        return numArr;
    }

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
