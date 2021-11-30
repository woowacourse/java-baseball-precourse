package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuizMaker {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int LENGTH_OF_QUIZ = 3;

    public static List<Integer> createNewQuiz() {
        Set<Integer> quizSet = new HashSet<>();
        while (quizSet.size() < LENGTH_OF_QUIZ) {
            quizSet.add(Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }

        return new ArrayList<>(quizSet);
    }

}
