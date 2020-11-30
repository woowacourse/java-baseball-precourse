package domain;

import static domain.Message.BALL;
import static domain.Message.BLANK;
import static domain.Message.NOTHING;
import static domain.Message.STRIKE;
import static domain.Rule.BASEBALL_SIZE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author yhh1056
 * @since 2020/11/28
 */
public class Hint {
    private static final int NO_COUNT = 0;

    private int strikeCount = 0;
    private int ballCount = 0;

    public Hint(BaseballNumber baseballNumber, BaseballNumber playerBaseballNumber) {
        findHint(baseballNumber, playerBaseballNumber);
    }

    private void findHint(BaseballNumber baseballNumber, BaseballNumber playerBaseballNumber) {
        for (int index : getIndexes()) {
            int number = baseballNumber.getNumber(index);
            int playerNumber = playerBaseballNumber.getNumber(index);
            if (baseballNumber.contains(playerNumber)) {
                findStrike(number, playerNumber);
                findBall(number, playerNumber);
            }
        }
    }

    private List<Integer> getIndexes() {
        return IntStream.range(0, BASEBALL_SIZE).boxed().collect(Collectors.toList());
    }

    private void findStrike(int number, int playerNumber) {
        if (number == playerNumber) {
            ++strikeCount;
        }
    }

    private void findBall(int number, int playerNumber) {
        if (number != playerNumber) {
            ++ballCount;
        }
    }

    @Override
    public String toString() {
        if (strikeCount == NO_COUNT && ballCount == NO_COUNT) {
            return nothing();
        }
        if (strikeCount == NO_COUNT) {
            return ballCount();
        }
        if (ballCount == NO_COUNT) {
            return strikeCount();
        }
        return ballAndStrikeCount();
    }

    private String nothing() {
        return new StringBuilder().append(NOTHING)
            .toString();
    }

    private String ballCount() {
        return new StringBuilder()
            .append(ballCount).append(BALL)
            .toString();
    }

    private String strikeCount() {
        return new StringBuilder()
            .append(strikeCount).append(STRIKE)
            .toString();
    }

    private String ballAndStrikeCount() {
        return new StringBuilder()
            .append(ballCount).append(BALL)
            .append(BLANK)
            .append(strikeCount).append(STRIKE)
            .toString();
    }
}
