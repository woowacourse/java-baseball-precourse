package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Computer {
    private int answer[];

    public Computer() {
        this.answer = new int[Constant.NUMBER_OF_NUMBERS];
    }

    public void setAnswer() {
        boolean[] used = new boolean[Constant.MAX_VALUE + 1];
        Arrays.fill(used, false);

        for (int i = 0; i < Constant.NUMBER_OF_NUMBERS; i++) {
            this.answer[i] = generateRandomNumber(used);
            used[this.answer[i]] = true;
        }
    }

    private int generateRandomNumber(boolean[] used) {
        while (true) {
            int num = Randoms.pickNumberInRange(Constant.MIN_VALUE, Constant.MAX_VALUE);
            if (!used[num]) {
                return num;
            }
        }
    }

    public int[] getAnswer() {
        return this.answer;
    }
}
