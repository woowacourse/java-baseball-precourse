package baseball.domain;

public class Score {
    private int ball;
    private int strike;

    public void increaseBallCount() {
        ball++;
    }

    public void increaseStrikeCount() {
        strike++;
    }
}
