package baseballgame;

import java.util.Objects;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-11-28
 */
public class BallCountCalculator {
    private final Number answer;

    public BallCountCalculator(Number answer) {
        this.answer = Objects.requireNonNull(answer);
    }

    public BallCount getBallCount(Number number) {
        int strike = getStrike(number);
        int ball = getBall(number);
        return new BallCount(strike, ball);
    }

    public int getStrike(Number number) {
        int strike = 0;
        for (int index = 0; index < Number.TOTAL_NUMBER; ++index) {
            if (isStrike(index, number)) {
                ++strike;
            }
        }
        return strike;
    }

    public int getBall(Number number) {
        int ball = 0;
        for (int index = 0; index < Number.TOTAL_NUMBER; ++index) {
            if (!isStrike(index, number) && answer.contains(number.get(index))) {
                ++ball;
            }
        }
        return ball;
    }

    public boolean isStrike(int index, Number number) {
        return answer.get(index).equals(number.get(index));
    }
}
