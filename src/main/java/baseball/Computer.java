package baseball;

import utils.RandomUtils;

public class Computer {
    private int[] answer = new int[Constant.NUMBER_LENGTH];
    private boolean[] alreadyUse = new boolean[Constant.MAX_VALUE + 1];

    public void generateAnswer() {
        for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
            int number = RandomUtils.nextInt(Constant.MIN_VALUE, Constant.MAX_VALUE);

            if (!alreadyUse[number]) {
                alreadyUse[number] = true;
                answer[i] = number;
            } else {
                i--;
            }
        }
    }

    public int[] getAnswer() {
        return this.answer;
    }
}
