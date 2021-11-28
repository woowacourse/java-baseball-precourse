package baseball;

import static baseball.Message.*;

public class PrintResult {
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
