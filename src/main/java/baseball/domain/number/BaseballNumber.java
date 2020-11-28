package baseball.domain.number;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballNumber {
    private static final Map<Integer, BaseballNumber> CACHE = new HashMap<>();
    private static final int RANGE_MINIMUM = 1;
    private static final int RANGE_MAXIMUM = 9;

    private final int baseballNumber;

    private BaseballNumber(int baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public static BaseballNumber of(int baseballNumber) {
        validateBaseballNumberRange(baseballNumber);
        return CACHE.computeIfAbsent(baseballNumber, BaseballNumber::new);
    }

    private static void validateBaseballNumberRange(int baseballNumber) {
        if (baseballNumber < RANGE_MINIMUM || baseballNumber > RANGE_MAXIMUM) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isDuplicated(List<BaseballNumber> baseballNumbers) {
        return baseballNumbers.contains(this);
    }

    public int getBaseballNumber() {
        return this.baseballNumber;
    }
}
