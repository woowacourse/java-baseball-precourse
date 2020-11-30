package baseball;

public class Score {

    private int strikeCnt;
    private int ballCnt;

    public Score(int strikeCnt, int ballCnt){
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public int getStrikeCnt(){
        return strikeCnt;
    }

    public int getBallCnt(){
        return ballCnt;
    }
}
