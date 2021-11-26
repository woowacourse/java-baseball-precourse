package baseball;

public class PrintResult {
    private static final String ALL_STRIKE_MSG = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STRIKE_MSG = "스트라이크";
    private static final String BALL_MSG = "볼";
    private static final String NOTHING_MSG = "낫싱";
    private int ballCnt;
    private int strikeCnt;

    NumberComparator numberComparator;

    public void setNumberComparator(NumberComparator numberComparator) {
        this.numberComparator = numberComparator;
    }

    public void result() {
        ballCnt = numberComparator.getBall();
        strikeCnt = numberComparator.getStrike();

        printMsg();
        if (strikeCnt == 3) {

        }
    }

    private void printMsg() {
        if (ballCnt > 0) {
            System.out.print(ballCnt + BALL_MSG);
        }

        if (ballCnt > 0 && strikeCnt > 0) {
            System.out.print(" ");
        }

        if (strikeCnt > 0) {
            System.out.print(strikeCnt + STRIKE_MSG);
        }

        if (strikeCnt == 3) {
            System.out.print(ALL_STRIKE_MSG);
        }

        if (ballCnt == 0 && strikeCnt == 0) {
            System.out.println(NOTHING_MSG);
        }

        System.out.println();
    }
}
