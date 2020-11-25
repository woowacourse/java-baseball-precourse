package domain.number;

import java.util.HashMap;
import java.util.Map;

public class BaseballNumber {
    private static final Map<Integer, BaseballNumber> CACHE = new HashMap<>();

    static {
        for (int i = 1; i <= 9; i++) {
            CACHE.put(i, new BaseballNumber(i));
        }
    }

    private final int baseballNumber;

    public BaseballNumber(int baseballNumber) {
        if (baseballNumber < 1 || baseballNumber > 9) {
            throw new IllegalArgumentException();
        }
        this.baseballNumber = baseballNumber;
    }

    public static BaseballNumber of(int baseballNumber) {
        return CACHE.computeIfAbsent(baseballNumber, key -> {
            throw new IllegalArgumentException();
        });
    }
}
