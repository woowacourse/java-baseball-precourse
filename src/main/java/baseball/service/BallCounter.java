package baseball.service;

import baseball.constant.Constants;

import java.util.List;

public class BallCounter {
    private static int ballCount;
    private static int strikeCount;

    private BallCounter() {
    }

    public static void count(List<Integer> answer, List<Integer> userNumber) {
        reset();

        for (int index = Constants.VALUE_ZERO; index < Constants.ANSWER_LENGTH; index++) {
            if (userNumber.get(index).equals(answer.get(index))) {
                strikeCount++;
                continue;
            }

            if (userNumber.contains(answer.get(index))) {
                ballCount++;
            }

        }

    }

    public static int getBallCount() {
        return ballCount;
    }

    public static int getStrikeCount() {
        return strikeCount;
    }

    public static void reset() {
        ballCount = Constants.VALUE_ZERO;
        strikeCount = Constants.VALUE_ZERO;
    }
}
