package baseball;

import static util.GameConstant.*;

public class Result {
    private final int strikeCnt;
    private final int ballCnt;

    public Result(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public boolean isAnswer() {
        return getStrikeCnt() == 3;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public String makeResultSentence() {
        if (strikeCnt == 3) {
            return THREE_STRIKE_MESSAGE;
        } else if (strikeCnt == 0 & ballCnt == 0) {
            return NOTHING_MESSAGE;
        }
        String resultSentence = "";
        if (ballCnt != 0) {
            resultSentence += ballCnt + BALL;
        }
        if (strikeCnt != 0) {
            resultSentence += strikeCnt + STRIKE;
        }
        return resultSentence;
    }
}
