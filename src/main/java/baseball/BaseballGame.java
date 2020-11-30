package baseball;

import domain.BaseballNumber;
import domain.Hint;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class BaseballGame {
    private final BaseballNumber baseballNumber;

    public BaseballGame(BaseballNumber baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public boolean matchBaseball(BaseballNumber playerBaseballNumber) {
        return isEquals(playerBaseballNumber);
    }

    private boolean isEquals(BaseballNumber playerBaseballNumber) {
        return baseballNumber.equals(playerBaseballNumber);
    }

    public Hint countStrikeAndBall(BaseballNumber playerBaseballNumber) {
        return findStrikeAndBall(playerBaseballNumber);
    }

    private Hint findStrikeAndBall(BaseballNumber playerBaseballNumber) {
        return new Hint(baseballNumber, playerBaseballNumber);
    }
}
