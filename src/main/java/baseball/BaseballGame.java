package baseball;

import static domain.Message.BINGO;

import domain.BaseballNumber;
import domain.Hint;
import java.util.Arrays;
import java.util.List;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class BaseballGame {
    private static final List<Integer> INDEXES = Arrays.asList(0, 1, 2);

    private final BaseballNumber baseballNumber;

    public BaseballGame(BaseballNumber baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public boolean matchBaseball(BaseballNumber playerBaseballNumber) {
        if (isEquals(playerBaseballNumber)) {
            showBingoMessage();
            return true;
        }
        return false;
    }

    private boolean isEquals(BaseballNumber playerBaseballNumber) {
        return baseballNumber.equals(playerBaseballNumber);
    }

    private void showBingoMessage() {
        System.out.println(BINGO.toString());
    }

    public Hint countStrikeAndBall(BaseballNumber playerBaseballNumber) {
        Hint hint = new Hint();
        findStrikeAndBall(hint, playerBaseballNumber);
        return hint;
    }

    private void findStrikeAndBall(Hint hint, BaseballNumber playerBaseballNumber) {
        for (int index : INDEXES) {
            int number = baseballNumber.getNumber(index);
            int playerNumber = playerBaseballNumber.getNumber(index);
            if (baseballNumber.contains(playerNumber)) {
                hint.findStrike(number, playerNumber);
                hint.findBall(number, playerNumber);
            }
        }
    }
}
