package baseball.model;

import java.util.List;

public class ScoreBoard {

    public static int ball;
    public static int strike;

    private static final int RESET = 0;
    private static final int THREE_STRIKE = 3;

    public static void resetBaord() {
        ball = RESET;
        strike = RESET;
    }

    public static boolean isThreeStrike() {
        return strike == THREE_STRIKE;
    }

    public static void updateBallCount(List<Integer> computerBalls, int computerNumber,
        int userNumber) {
        if (computerNumber != userNumber && computerBalls.contains(userNumber)) {
            ball += 1;
        }
    }

    public static void updateStrikeCount(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            strike += 1;
        }
    }
}
