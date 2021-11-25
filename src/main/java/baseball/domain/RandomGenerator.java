package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    private static RandomGenerator instance;
    private int[] answer;

    private RandomGenerator() {
        generateRandomAnswer();
    }

    public static RandomGenerator getInstance() {
        if (instance == null) {
            return new RandomGenerator();
        }

        return instance;
    }

    private void generateRandomAnswer() {
        answer = new int[3];
        while (checkDuplicateNumber()) {
            generateRandomNumbers();
        }
    }

    private void generateRandomNumbers() {
        for (int i = 0; i < 3; i++) {
            answer[i] = Randoms.pickNumberInRange(1, 9);
        }
    }

    private boolean checkDuplicateNumber() {
        return answer[0] == answer[1] || answer[0] == answer[2] || answer[1] == answer[2];
    }

    public int[] getAnswer() {
        return answer;
    }

    public void reGenerate() {
        generateRandomAnswer();
    }
}
