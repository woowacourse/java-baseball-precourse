package baseball.controller;

import baseball.domain.User;
import baseball.viewer.OutputShower;

public class OutputShowSelector {
    private static final int END_GAME = 3;

    /**
     * 사용자의 게임 상태를 받아 상태를 판단하여 사용자에게 보여주는 메서드
     *
     * @param user 사용자의 게임 상태를 가지고 있는 인스턴스
     */
    public static void outputPrint(User user) {
        int ballNumber = user.getBallNumber();
        int strikeNumber = user.getStrikeNumber();
        judgeGradeShower(ballNumber, strikeNumber);
        judgeGameOver(strikeNumber);
    }

    private static void judgeGradeShower(int ballNumber, int strikeNumber) {
        if ((ballNumber != 0) && (strikeNumber != 0)) {
            OutputShower.showBothBallStrike(ballNumber, strikeNumber);
            return;
        }
        if ((ballNumber == 0) && (strikeNumber == 0)) {
            OutputShower.showNothing();
            return;
        }
        judgebiasedGradeShower(ballNumber, strikeNumber);
    }

    private static void judgebiasedGradeShower(int ballNumber, int strikeNumber) {
        if (ballNumber != 0) {
            OutputShower.showBall(ballNumber);
            return;
        }
        OutputShower.showStrike(strikeNumber);
    }

    private static void judgeGameOver(int strikeNumber) {
        if (strikeNumber == END_GAME) {
            OutputShower.showGameOver();
        }
    }
}
