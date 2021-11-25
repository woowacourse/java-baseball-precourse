package baseball;


public class Result {
    private int strikeCnt;
    private int ballCnt;

    public Result(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public boolean isAnswer() {
        if (getStrikeCnt() == 3) {
            return true;
        }
        return false;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public String makeResultSentence() {
        if (strikeCnt == 3) {
            return "3스트라이크";
        }
        if (strikeCnt == 0 & ballCnt == 0) {
            return "낫싱";
        }
        String resultSentence = "";
        if (ballCnt != 0) {
            resultSentence += Integer.toString(ballCnt)+"볼 ";
        }
        if (strikeCnt != 0) {
            resultSentence += Integer.toString(strikeCnt) + "스트라이크";
        }
        return resultSentence;
    }
}
