package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static Computer instance;
    private static List<Integer> answer = new ArrayList<>();
    private final int BALL = 0;
    private final int STRIKE = 1;

    private Computer() {
        generateRandomAnswer();
    }

    public static Computer getInstance() {
        if (instance == null) {
            return new Computer();
        }
        generateRandomAnswer();
        return instance;
    }

    private static void generateRandomAnswer() {
        answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (answer.contains(number)) {
                i--;
                continue;
            }
            answer.add(number);
        }
    }

    public int[] generateHint(int[] playerNumber) {
        int[] hint = new int[2];
        int strikeCount = countStrike(playerNumber);
        int ballCount = countBall(playerNumber);

        hint[STRIKE] = strikeCount;
        hint[BALL] = ballCount;

        return hint;
    }

    private int countBall(int[] playerNumber) {
        int count = 0;
        if (playerNumber[0] == answer.get(1) || playerNumber[0] == answer.get(2)) {
            count++;
        } else if (playerNumber[1] == answer.get(0) || playerNumber[1] == answer.get(2)) {
            count++;
        } else if (playerNumber[2] == answer.get(0) || playerNumber[2] == answer.get(1)) {
            count++;
        }

        return count;
    }

    private int countStrike(int[] playerNumber) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (playerNumber[i] == answer.get(i)) {
                count++;
            }
        }
        return count;
    }
}
