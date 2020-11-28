package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    private static final int START_BOUND = 1;
    private static final int END_BOUND = 9;

    private List<Integer> answers = new ArrayList<>();

    public List<Integer> getAnswers() {
        return answers;
    }

    public Answer() {
        generateNewAnswers();
    }

    private void generateNewAnswers() {
        initAnswers();
        while (answers.size() < 3)
            generateOneAnswer();
    }

    private void initAnswers() {
        answers.clear();
    }

    private void generateOneAnswer() {
        int newAnswer = RandomUtils.nextInt(START_BOUND, END_BOUND);
        if (isUniqueAnswer(newAnswer))
            answers.add(newAnswer);
    }

    private boolean isUniqueAnswer(int given) {
        return !answers.contains(given);
    }
}
