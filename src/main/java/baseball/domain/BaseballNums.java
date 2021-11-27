package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNums {
    public static final int MIN_BASEBALL_NUMBER = 1;
    public static final int MAX_BASEBALL_NUMBER = 9;
    public static final int BASEBALL_NUMBERS_LENGTH = 3;
    private final List<Integer> baseballNums;

    public BaseballNums(List<Integer> baseballNums) {
        isValidateLength(baseballNums);
        isValidateDuplicated(baseballNums);
        this.baseballNums = baseballNums;
    }

    private void isValidateLength(List<Integer> baseballNums) {
        if (baseballNums.size() != BASEBALL_NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void isValidateDuplicated(List<Integer> baseballNums) {
        Set<Integer> tempBaseballNums = new HashSet<>(baseballNums);
        if (tempBaseballNums.size() != BASEBALL_NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getBaseballNums() {
        return baseballNums;
    }
}