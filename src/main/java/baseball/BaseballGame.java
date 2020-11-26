package baseball;

import domain.BaseballNumber;
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
        this.baseballNumber = new BaseballNumber(createBaseballNumber());
    }

    private List<Integer> createBaseballNumber() {
        return RandomNumbers.valueOf(BASEBALL_LIST_SIZE);
    }
}
