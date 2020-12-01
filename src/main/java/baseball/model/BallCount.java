/**
 * BallCount.java
 * 스트라이크, 볼을 담을 Data Transfer Object
 *
 * @author Kimun Kim / kkm97351@gmail.com
 */

package baseball.model;

public class BallCount {
    private final int strike;
    private final int ball;

    private BallCount(final int strike, final int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    static BallCount createBallCount(final int strike, final int ball) {
        return new BallCount(strike, ball);
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    @Override
    public String toString() {
        return String.format("Strike: %d, Ball: %d", this.strike, this.ball);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        BallCount paramObj = (BallCount) obj;
        return (this.strike == paramObj.strike && this.ball == paramObj.ball);
    }

}
