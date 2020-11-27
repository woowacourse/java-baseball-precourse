package domain;

import java.util.List;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class BaseballNumber {
    public static final int BASEBALL_LIST_SIZE = 3;

    private final List<Integer> baseballNumbers;

    public BaseballNumber(final List<Integer> baseballNumbers) {
        validateSize(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validateSize(List<Integer> baseballNumbers) {
        if (baseballNumbers.size() != BASEBALL_LIST_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
