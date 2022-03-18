package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {

    private final int NUMBER_RANGE_START = 0;
    private final int NUMBER_RANGE_END = 9;
    private final int HOW_MANY_RANDOM_NUMBERS = 3;
    private final int DIGIT_NUMBER = 3;

    public BaseballGame() {

    }

    public List<Integer> makeRandomNumber() {
        List<Integer> randomNumList = Randoms.pickUniqueNumbersInRange(NUMBER_RANGE_START, NUMBER_RANGE_END, HOW_MANY_RANDOM_NUMBERS);
        return randomNumList;
    }

    public boolean correct(int[] grade) {
        return grade[0] == 3;
    }

    public int[] gradeAnswer(List<Integer> answerList, List<Integer> playerAnswer) {
        int strike = 0;
        int ball = 0;
        Set<Integer> ballCandidates = new HashSet<>();

        for (int i = 0; i < DIGIT_NUMBER; ++i) {
            if (answerList.get(i) == playerAnswer.get(i)) {
                ++strike;
                continue;
            }
            ballCandidates.add(answerList.get(i));
            if (ballCandidates.contains(playerAnswer.get(i))) {
                ++ball;
            }
        }
        return new int[]{strike, ball};
    }
}
