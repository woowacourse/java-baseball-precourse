package baseball;

import utils.RandomUtils;

public class GameSystem {
    private static final int MAX_DIGIT = 3;

    // 정답이 될 컴퓨터의 3자리 수
    private int[] answer = null;

    public GameSystem() {
        answer = new int[MAX_DIGIT];
    }

    private void setAnswer() {
        boolean[] numCheck = new boolean[10];
        int digit = 0;
        int tmpNum;

        while (digit < MAX_DIGIT) {
            tmpNum = RandomUtils.nextInt(1, 10);
            if (!numCheck[tmpNum]) {
                answer[digit] = tmpNum;
                numCheck[tmpNum] = true;
                digit++;
            }
        }
    }
}
