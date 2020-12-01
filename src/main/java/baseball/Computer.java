package baseball;

import utils.RandomUtils;

public class Computer {
    private int[] answer = new int[Constant.NUMBER_LEN];
    private boolean[] alreadyUse = new boolean[Constant.MAX_VALUE + 1];

    public void generateAnswer() {
        for (int i = 0; i < Constant.NUMBER_LEN; i++) {
            int num = RandomUtils.nextInt(Constant.MIN_VALUE, Constant.MAX_VALUE);

            if (!alreadyUse[num]) {
                alreadyUse[num] = true;
                answer[i] = num;
            } else {
                i--;
            }
        }
    }

    public int[] getAnswer() {
        return this.answer;
    }
}
