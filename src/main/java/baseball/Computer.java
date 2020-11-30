package baseball;

import utils.RandomUtils;

public class Computer {
    private static final int NUMBER_LEN = 3;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    int[] answer = new int[NUMBER_LEN];
    boolean[] alreadyUse = new boolean[MAX_VALUE + 1];

    public Computer () {
        for (int i = 0; i < NUMBER_LEN; i++) {
            int num = RandomUtils.nextInt(MIN_VALUE, MAX_VALUE);

            if (!alreadyUse[num]) {
                alreadyUse[num] = true;
                answer[i] = num;
            } else {
                i--;
            }
        }
    }
}
