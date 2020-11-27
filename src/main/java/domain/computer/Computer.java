package domain.computer;

import utils.RandomUtils;

import java.util.ArrayList;

public class Computer {
    private final static int START_VALUE_IN_RANDOM_NUMBER_RANGE = 1;
    private final static int END_VALUE_IN_RANDOM_NUMBER_RANGE = 9;
    ArrayList<Integer> answer = new ArrayList<>();

    public Computer() {
        makeRandomAnswer();
    }

    public boolean isCorrectAnswer(String[] userInput) {
        int strikeCount = 0;
        int ballCount = 0;
        ArrayList<Integer> convertedUserInputToInteger = new ArrayList<>();
        for (String x : userInput) {
            convertedUserInputToInteger.add(Integer.parseInt(x));
        }
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == convertedUserInputToInteger.get(i)) {
                strikeCount++;
                continue;
            }
            if (answer.contains(convertedUserInputToInteger.get(i))) {
                ballCount++;
                continue;
            }
        }
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
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public void makeRandomAnswer() {
        while (answer.size() != 3) {
            int randomNumber = RandomUtils.nextInt(
                    START_VALUE_IN_RANDOM_NUMBER_RANGE,
                    END_VALUE_IN_RANDOM_NUMBER_RANGE);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public void resetAnswer() {
        answer = new ArrayList<>();
        makeRandomAnswer();
    }
}