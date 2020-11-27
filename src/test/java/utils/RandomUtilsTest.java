package utils;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RandomUtilsTest {
    private static final int NUMBER_OF_TEST_CASES = 9000;

    @RepeatedTest(NUMBER_OF_TEST_CASES)
    public void nextInt() {
        int startInclusive = 1;
        int endInclusive = 9;

        int aRandomDigit = RandomUtils.nextInt(startInclusive, endInclusive);

        assertThat(aRandomDigit).isBetween(startInclusive, endInclusive);
    }

    @Test
    public void nextInt_startIsGreaterThanEnd() {
        int startInclusive = 9;
        int endInclusive = 1;

        assertThrows(IllegalArgumentException.class, () -> RandomUtils.nextInt(startInclusive, endInclusive));
    }

    @Test
    public void nextInt_negativeStart() {
        int startInclusive = -1;
        int endInclusive = 9;

        assertThrows(IllegalArgumentException.class, () -> RandomUtils.nextInt(startInclusive, endInclusive));
    }

    @Test
    public void nextInt_startIsEqualToEnd() {
        int startInclusive = 1;
        int endInclusive = 1;

        int aRandomDigit = RandomUtils.nextInt(startInclusive, endInclusive);

        assertThat(aRandomDigit).isEqualTo(startInclusive);
    }
}
