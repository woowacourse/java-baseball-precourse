package baseball;

import utils.RandomUtils;

public class Computer {

    private static final int RANGE_START = 1;
    private static final int RANGE_END = 9;
    private final int COUNT = BaseballGame.THREE_DIGIT;


    private int[] computerNumbers = new int[COUNT];

    public Computer() {
    }

    public int[] getComputerNumbers() {
        makeRandomNumbers();
        return computerNumbers;
    }

    private void makeRandomNumbers() {
        for (int i = 0; i < COUNT; i++) {
            computerNumbers[i] = RandomUtils.nextInt(RANGE_START, RANGE_END);
            i = checkSame(i);
        }
    }

    private int checkSame(int i) {
        for (int j = 0; j < i; j++) {
            if (computerNumbers[i] == computerNumbers[j]) {
                return i - 1;
            }
        }
        return i;
    }


}
