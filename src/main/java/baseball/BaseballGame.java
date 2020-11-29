package baseball;

import domain.BaseballNumber;
import domain.Hint;
import java.util.List;
import utils.RandomNumbers;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class BaseballGame {
    public static final int BASEBALL_LIST_SIZE = 3;

    private final BaseballNumber baseballNumber;

    public BaseballGame() {
        this.baseballNumber = new BaseballNumber(nonDuplicateNumber());
    }

    private List<Integer> nonDuplicateNumber() {
        return RandomNumbers.getInstance(BASEBALL_LIST_SIZE);
    }

    public boolean exists(BaseballNumber playerBaseballNumber) {
        return baseballNumber.equals(playerBaseballNumber);
    }

    public Hint countStrikeAndBall(BaseballNumber playerBaseballNumber) {
        Hint hint = new Hint();
        for (int i = 0; i < BASEBALL_LIST_SIZE; i++) {
            int number = playerBaseballNumber.getNumber(i);
            checkStrike(hint, number);
            checkBall(hint, number);
        }
        return hint;
    }

    private void checkStrike(Hint hint, int number) {
        if (isEqualsToIndexOf(number)) {
            hint.countStrike();
        }
    }

    private void checkBall(Hint hint, int number) {
        if (!isEqualsToIndexOf(number) && baseballNumber.contains(number)) {
            hint.countBall();
        }
    }

    private boolean isEqualsToIndexOf(int number) {
        return baseballNumber.indexOf(number) == number;
    }
}
