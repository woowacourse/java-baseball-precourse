package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class AnswerGenerator {

    private static final int LENGTH = 3;
    private static final int MIN_ANSWER_DIGIT = 1;
    private static final int MAX_ANSWER_DIGIT = 9;

    public int[] generate() {
        int[] answer = new int[LENGTH];

        int index = 0;
        Set<Integer> usedNumberSet = new HashSet<>();

        while(index < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(
                MIN_ANSWER_DIGIT,
                MAX_ANSWER_DIGIT
            );

            if(usedNumberSet.contains(randomNumber)) {
                continue;
            }

            answer[index] = randomNumber;
            usedNumberSet.add(randomNumber);
            index++;
        }

        return answer;
    }
}
