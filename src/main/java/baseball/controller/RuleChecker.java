package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;

public class RuleChecker {
    static final int NUMBER_OF_BALL = 3;

    public static void gradePoints(User user, Computer computer) {
        int strikeNumberThisTurn = 0;
        int ballNumberThisTurn = 0;
        int[] userBallBunch = user.getBallBunch();
        int[] computerBallBunch = computer.getBallBunch();

        for (int position = 0; position < NUMBER_OF_BALL; position++) {
            strikeNumberThisTurn += gradeStrike(userBallBunch, computerBallBunch, position);
            ballNumberThisTurn += gradeBall(userBallBunch, computerBallBunch, position);
        }

        gradePoints(user, ballNumberThisTurn, strikeNumberThisTurn);
    }

    private static int gradeStrike(int[] userBallBunch, int[] computerBallBunch, int turn) {
        int thisStrike = 0;

        if (userBallBunch[turn] == computerBallBunch[turn]) {
            thisStrike += 1;
        }

        return thisStrike;
    }

    private static int gradeBall(int[] userballBunch, int[] computerballBunch, int turn) {
        int thisBall = 0;

        for (int rotate = 0; rotate < NUMBER_OF_BALL; rotate++) {
            if ((rotate != turn) && (userballBunch[turn] == computerballBunch[rotate])) {
                thisBall += 1;
            }
        }

        return thisBall;
    }

    private static void gradePoints(User user, int targetBallPoint, int targetStrikePoint) {
        user.setBallNumber(targetBallPoint);
        user.setStrikeNumber(targetStrikePoint);
    }
}
