package domain;

import ui.Output;
import utils.RandomUtils;

import java.util.ArrayList;

public class Computer {
    private final static int START_VALUE_IN_RANDOM_NUMBER_RANGE = 1;
    private final static int END_VALUE_IN_RANDOM_NUMBER_RANGE = 9;
    private final static int VALID_NUMBER_SIZE = 3;
    private final static int STRIKE_FULL_COUNT = 3;
    private ArrayList<Integer> answer = new ArrayList<>();
    private int strikeCount;
    private int ballCount;

    public Computer() {
        makeRandomAnswer();
    }

    public boolean isCorrectAnswer(String[] userInput) {
        strikeCount = 0;
        ballCount = 0;
        countStrikeAndBall(userInput);
        Output.printBallOrStrikeCount(strikeCount, ballCount);
        if (strikeCount == STRIKE_FULL_COUNT) {
            System.out.println(Output.CORRECT_ANSWER_AND_EXIT_GAME);
            return true;
        }
        return false;
    }

    public void resetAnswer() {
        answer = new ArrayList<>();
        makeRandomAnswer();
    }

    private void countStrikeAndBall(String[] userInput) {
        ArrayList<Integer> convertedUserInputToInteger = new ArrayList<>();
        for (String x : userInput) {
            convertedUserInputToInteger.add(Integer.parseInt(x));
        }
        for (int i = 0; i < answer.size(); i++) {
            checkStrikeOrBallAndCount(answer.get(i), convertedUserInputToInteger.get(i));
        }
    }

    private void checkStrikeOrBallAndCount(int oneNumberOfAnswer, int oneNumberOfInput) {
        if (oneNumberOfAnswer == oneNumberOfInput) {
            strikeCount++;
            return;
        }
        if (answer.contains(oneNumberOfInput)) {
            ballCount++;
            return;
        }
    }

    private void makeRandomAnswer() {
        int randomNumber = RandomUtils.nextInt(
                START_VALUE_IN_RANDOM_NUMBER_RANGE,
                END_VALUE_IN_RANDOM_NUMBER_RANGE);
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
        if (answer.size() != VALID_NUMBER_SIZE) {
            makeRandomAnswer();
        }
    }
}