package baseball.domain;

public class BaseBall {
    int strikeCount;
    int ballCount;

    public BaseBall() {
        strikeCount = 0;
        ballCount = 0;
    }

    public void initBaseBall() {
        strikeCount = 0;
        ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void incStrikeCount() {
        strikeCount += 1;
    }

    public void incBallCount() {
        ballCount += 1;
    }
}
