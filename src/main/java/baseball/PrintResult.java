package baseball;

import static baseball.config.Constant.*;
import static baseball.config.Message.*;

public class PrintResult {
    private final int ballCnt;
    private final int strikeCnt;

    public PrintResult(int strike, int ball) {
        this.strikeCnt = strike;
        this.ballCnt = ball;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (ballCnt > NONE) {
            stringBuilder.append(ballCnt).append(BALL_MSG);
        }

        if (ballCnt > NONE && strikeCnt > NONE) {
            stringBuilder.append(" ");
        }

        if (strikeCnt > NONE) {
            stringBuilder.append(strikeCnt).append(STRIKE_MSG);
        }

        if (strikeCnt == MAX_STRIKES) {
            stringBuilder.append(ALL_STRIKE_MSG);
        }

        if (ballCnt == NONE && strikeCnt == NONE) {
            stringBuilder.append(NOTHING_MSG);
        }

        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}