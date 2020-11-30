package utils;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
class RandomUtilsTest {
    int startInclusive = 1;
    int endInclusive = 9;

    @Test
    @DisplayName("1 ~ 9 사이의 숫자가 생성")
    void nextInt() {
        int testLength = 100_000;

        for (int i = 0; i < testLength; i++) {
            int randomNumber = RandomUtils.nextInt(startInclusive, endInclusive);
            assertTrue((1 <= randomNumber) && (randomNumber <= 9));
        }
    }

    @Test
    @DisplayName("올바르지 않은 범위 값을 입력한 경우")
    void invalidParameter() {
        assertAll(
            // startInclusive > endInclusive
            () -> assertThrows(IllegalArgumentException.class,
                () -> RandomUtils.nextInt(endInclusive, startInclusive)),

            // startInclusive < 0
            () -> assertThrows(
                IllegalArgumentException.class,
                () -> RandomUtils.nextInt(-1, endInclusive))
        );
    }

    @Test
    @DisplayName("같은 값을 입력한 경우")
    void equalsParameter() {
        assertEquals(startInclusive, RandomUtils.nextInt(startInclusive, startInclusive));
    }
}
