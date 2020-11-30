package baseball;

public class Referee {
    private int ballCnt;
    private int strikeCnt;

    public Referee() {
    }

    private void initCnt() {
        ballCnt = 0;
        strikeCnt = 0;
    }

    public void compareNumber(String answer, String guess) {
    }

    public void isBall(int i, String answer, char crtGuess) {
    }

    public void isStrike(char crtAnswer, char crtGuess) {
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public int getStrikeCnt(){
        return strikeCnt;
    }
}