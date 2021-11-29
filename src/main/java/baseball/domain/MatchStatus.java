package baseball.domain;

public class MatchStatus {
    int numOfBall;
    int numOfStrike;

    public void countBallNumber() {
        this.numOfBall++;
    }

    public void countStrikeNumber() {
        this.numOfStrike++;
    }

    @Override
    public String toString() {
        if (numOfBall == 0 && numOfStrike == 0) {
            return "낫싱";
        }

        if (numOfBall != 0 && numOfStrike != 0) {
            return getBallNumberString() + " " + getStrikeNumberString();
        }

        return getBallNumberString() + getStrikeNumberString();
    }

    public String getStrikeNumberString() {
        if (numOfStrike == 0) {
            return "";
        }

        return numOfStrike + "스트라이크";
    }

    public String getBallNumberString() {
        if (numOfBall == 0) {
            return "";
        }

        return numOfBall + "볼";
    }
}
