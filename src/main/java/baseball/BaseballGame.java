package baseball;

import static domain.Rule.BASEBALL_SIZE;

import domain.BaseballNumber;
import domain.Hint;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        Hint hint = new Hint();
        findStrikeAndBall(hint, playerBaseballNumber);
        return hint;
    }

    private void findStrikeAndBall(Hint hint, BaseballNumber playerBaseballNumber) {
        for (int index : getIndexes()) {
            int number = baseballNumber.getNumber(index);
            int playerNumber = playerBaseballNumber.getNumber(index);
            if (baseballNumber.contains(playerNumber)) {
                hint.findStrike(number, playerNumber);
                hint.findBall(number, playerNumber);
            }
        }
    }

    private List<Integer> getIndexes() {
        return IntStream.range(0, BASEBALL_SIZE).boxed().collect(Collectors.toList());
    }
}
