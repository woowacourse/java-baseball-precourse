package baseball;

public class Result {
    private int strikeCnt;
    private int ballCnt;

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
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else if (strikeCnt == 0 & ballCnt == 0) {
            return "낫싱";
        }
        String resultSentence = "";
        if (ballCnt != 0) {
            resultSentence += ballCnt + "볼 ";
        }
        if (strikeCnt != 0) {
            resultSentence += strikeCnt + "스트라이크";
        }
        return resultSentence;
    }
}
