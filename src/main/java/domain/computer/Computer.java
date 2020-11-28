package domain.computer;

import ui.Output;
import utils.RandomUtils;

import java.util.ArrayList;

public class Computer {
    private final static int START_VALUE_IN_RANDOM_NUMBER_RANGE = 1;
    private final static int END_VALUE_IN_RANDOM_NUMBER_RANGE = 9;
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
        printBallOrStrikeCount(strikeCount, ballCount);
        if (strikeCount == 3) {
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

    private void printBallOrStrikeCount(int strikeCount, int ballCount) {
        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    private void makeRandomAnswer() {
        int randomNumber = RandomUtils.nextInt(
                START_VALUE_IN_RANDOM_NUMBER_RANGE,
                END_VALUE_IN_RANDOM_NUMBER_RANGE);
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
        if (answer.size() != 3) {
            makeRandomAnswer();
        }
    }
}