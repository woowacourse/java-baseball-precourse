package baseball;

import domain.BaseballNumber;
import java.util.List;
import utils.RandomNumbers;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class BaseballGame {
    private final BaseballNumber baseballNumber;

    public BaseballGame() {
        this.baseballNumber = new BaseballNumber(createBaseballNumber());
    }

    private List<Integer> createBaseballNumber() {
        return RandomNumbers.valueOf(3);
    }
}
