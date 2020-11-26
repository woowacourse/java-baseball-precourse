package baseball.domain.pitching;

import baseball.domain.pitching.exception.PitchingOutOfRangeException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Pitching {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    private static final Map<Integer, Pitching> CACHE = new HashMap<>();

    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            CACHE.put(i, new Pitching(i));
        }
    }

    private final int value;

    private Pitching(final int value) {
        this.value = value;
    }

    public static Pitching of(final String value) {
        return of(Integer.parseInt(value));
    }

    public static Pitching of(final int value) {
        validate(value);
        return CACHE.get(value);
    }

    private static void validate(final int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new PitchingOutOfRangeException(value);
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
        Pitching pitching = (Pitching) o;
        return value == pitching.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
