package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomAnswer {

    public int[] generate() {
        final int startInclusive = 1;
        final int endInclusive = 9;
        boolean[] checkUnique = new boolean[10];

        int[] answer = new int[Constants.ANSWER_LENGTH];
        for (int i=0; i<Constants.ANSWER_LENGTH; i++) {
            while (true) {
                int digit = Randoms.pickNumberInRange(startInclusive, endInclusive);
                if (!checkUnique[digit]) {
                    checkUnique[digit] = !checkUnique[digit];
                    answer[i] = digit;
                    break;
                }
            }
        }
        return answer;
    }
}