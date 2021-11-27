package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    private int[] answer = new int[3];
    private boolean[] usedNum = new boolean[9];

    public int[] generateAnswer() {
        for (int digit = 0; digit < 3; digit++) {
            int pickNum = pickNumberInRange(1, 9);

            if (!usedNum[pickNum - 1]) {
                usedNum[pickNum - 1] = true;
                answer[digit] = pickNum;
                continue;
            }
            digit--;
        }

        return answer;
    }

}
