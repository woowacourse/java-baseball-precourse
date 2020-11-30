package baseball.domain;

import static baseball.config.BaseballConfiguration.BALL_LENGTH;

public class Score {
    private int ball;
    private int strike;

    public Score() {
    }

    public void increaseBallCount() {
        ball++;
    }

    public void increaseStrikeCount() {
        strike++;
    }

    public boolean isZeroBall() {
        return ball == 0;
    }

    public boolean isZeroStrike() {
        return strike == 0;
    }

    public boolean isFullStrike() {
        return strike == BALL_LENGTH;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
