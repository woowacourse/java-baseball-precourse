package domain;

import java.util.List;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class BaseballNumber {
    private final List<Integer> baseballNumber;

    public BaseballNumber(final List<Integer> nonDuplicateNumber) {
        this.baseballNumber = nonDuplicateNumber;
    }
}
