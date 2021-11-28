package baseball;

import static baseball.InitialSetting.*;

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
        if (ballCnt > NONE) {
            System.out.print(ballCnt + BALL_MSG);
        }

        if (ballCnt > NONE && strikeCnt > NONE) {
            System.out.print(" ");
        }

        if (strikeCnt > NONE) {
            System.out.print(strikeCnt + STRIKE_MSG);
        }

        if (strikeCnt == MAX_STRIKES) {
            System.out.print(ALL_STRIKE_MSG);
        }

        if (ballCnt == NONE && strikeCnt == NONE) {
            System.out.println(NOTHING_MSG);
        }

        System.out.println();
    }
}
