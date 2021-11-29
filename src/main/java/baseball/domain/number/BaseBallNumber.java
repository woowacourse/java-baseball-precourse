package baseball.domain.number;

import baseball.exception.number.BaseBallNumberRangeException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class BaseBallNumber {

    public final static int MIN_NUMBER = 1;
    public final static int MAX_NUMBER = 9;

    private static final Map<Integer, BaseBallNumber> CACHE_NUMBERS = new HashMap<>();

    private final int number;

    static {
        IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .forEach(number -> CACHE_NUMBERS.put(number, new BaseBallNumber(number)));
    }

    private BaseBallNumber(int number) {
        this.number = number;
    }

    public static BaseBallNumber from(int number) {
        checkNumberRange(number);
        return CACHE_NUMBERS.get(number);
    }

    private static void checkNumberRange(int number) {
        if (!CACHE_NUMBERS.containsKey(number)) {
            throw new BaseBallNumberRangeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseBallNumber that = (BaseBallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
