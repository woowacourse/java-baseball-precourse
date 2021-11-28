package baseball;

import constant.SystemMessage;

public class BallCount {
    private int strike;
    private int ball;

    public BallCount() {
        this.strike = SystemMessage.ZERO;
        this.ball = SystemMessage.ZERO;
    }

    public void plusStrike() {
        strike++;
    }

    public void plusBall() {
        ball++;
    }

    public boolean isStrikeOut() {
        return this.strike == SystemMessage.STRIKE_VALUE;
    }

    public void printCurrentBallCount() {
        if (ball != SystemMessage.ZERO) {
            System.out.printf("%d%s ", ball, SystemMessage.BALL);
        }
        if (strike != SystemMessage.ZERO) {
            System.out.printf("%d%s", strike, SystemMessage.STRIKE);
        }
        if (ball == SystemMessage.ZERO && strike == SystemMessage.ZERO) {
            System.out.printf("%s", SystemMessage.NOTHING);
        }
        System.out.println();
    }

}
