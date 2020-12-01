package view;

import baseball.Score;

public class OutputView {
    private static final String ANNOUNCE_BALL_CNT = "볼 ";
    private static final String ANNOUNCE_STRIKE_CNT = "스트라이크";
    private static final String ANNOUNCE_NOTHING = "낫싱";
    private static final String SEPARATOR_ROUND = "\n";
    private static final String ANNOUNCE_ALL_CORRECT = "개의 숫자를 모두 맞히셨습니다! 게임 종료 \n";

    private OutputView(){}

    public static void printScore(Score score) {
        int ballCnt = score.getBallCnt();
        int strikeCnt = score.getStrikeCnt();

        printBallPoint(ballCnt);
        printStrikePoint(strikeCnt);
        printIsNothing(ballCnt, strikeCnt);

        printMsg(SEPARATOR_ROUND);
    }

    private static void printBallPoint(int ballCnt) {
        if (ballCnt != 0) {
            printMsg(ballCnt);
            printMsg(ANNOUNCE_BALL_CNT);
        }
    }

    private static void printStrikePoint(int strikeCnt) {
        if (strikeCnt != 0) {
            printMsg(strikeCnt);
            printMsg(ANNOUNCE_STRIKE_CNT);
        }
    }

    private static void printIsNothing(int ballCnt, int strikeCnt) {
        if (ballCnt == 0 && strikeCnt == 0) {
            printMsg(ANNOUNCE_NOTHING);
        }
    }

    public static void printGameOver() {
        printMsg(ANNOUNCE_ALL_CORRECT);
    }

    public static void printMsg(Object msg) {
        System.out.print(msg);
    }
}
