package baseball;

public class Referee {
    private int ballCnt;
    private int strikeCnt;

    private void initCnt() {
        ballCnt = 0;
        strikeCnt = 0;
    }

    private void isBall(int i, String answer, char crtGuess) {
        if (answer.indexOf(crtGuess) != -1 && answer.charAt(i) != crtGuess) {
            ballCnt++;
        }
    }

    private void isStrike(char crtAnswer, char crtGuess) {
        if (crtAnswer == crtGuess) {
            strikeCnt++;
        }
    }

    public void compareNumber(String answer, String guess) {
        initCnt();
        for (int i = 0; i < 3; i++) {
            char crtAnswer = answer.charAt(i);
            char crtGuess = guess.charAt(i);
            isBall(i, answer, crtGuess);
            isStrike(crtAnswer, crtGuess);
        }
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public int getStrikeCnt(){
        return strikeCnt;
    }
}