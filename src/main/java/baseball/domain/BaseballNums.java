package baseball.domain;

import java.util.List;

public class BaseballNums {
    public static final int MIN_BASEBALL_NUMBER = 1;
    public static final int MAX_BASEBALL_NUMBER = 9;
    public static final int BASEBALL_NUMBERS_LENGTH = 3;
    private final List<Integer> baseballNums;

    public BaseballNums(List<Integer> baseballNums) {
        this.baseballNums = baseballNums;
    }
}