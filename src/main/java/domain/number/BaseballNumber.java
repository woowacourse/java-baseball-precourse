package domain.number;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballNumber {
    private static final Map<Integer, BaseballNumber> CACHE = new HashMap<>();
    private static final int RANGE_MINIMUM = 1;
    private static final int RANGE_MAXIMUM = 9;

    static {
        for (int i = RANGE_MINIMUM; i <= RANGE_MAXIMUM; i++) {
            CACHE.put(i, new BaseballNumber(i));
        }
    }

    private final int baseballNumber;

    private BaseballNumber(int baseballNumber) {
        validateBaseballNumberRange(baseballNumber);
        this.baseballNumber = baseballNumber;
    }

    public static BaseballNumber of(int baseballNumber) {
        return CACHE.computeIfAbsent(baseballNumber, key -> {
            throw new IllegalArgumentException();
        });
    }

    private void validateBaseballNumberRange(int baseballNumber) {
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
