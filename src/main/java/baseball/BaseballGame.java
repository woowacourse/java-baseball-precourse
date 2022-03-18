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
        List<Integer> answerList = Randoms.pickUniqueNumbersInRange(NUMBER_RANGE_START, NUMBER_RANGE_END, HOW_MANY_RANDOM_NUMBERS);
        return answerList;
    }

    public boolean correct(int[] grade) {
        return grade[0] == 3;
    }

    public int[] gradeAnswer(List<Integer> answerList, List<Integer> playerAnswer) {
        int strike = 0;
        int ball = 0;
        Set<Integer> ballCandidates = new HashSet<>();
        ballCandidates.addAll(answerList);

        for (int i = 0; i < DIGIT_NUMBER; ++i) {
            if (answerList.get(i) == playerAnswer.get(i)) {
                ++strike;
                ballCandidates.remove(answerList.get(i));
                continue;
            }
            if (ballCandidates.remove(playerAnswer.get(i))) {
                ++ball;
            }
        }

        Output playerOutput = new Output();
        playerOutput.printScore(strike, ball);

        return new int[]{strike, ball};
    }
}
