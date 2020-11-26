package utils;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
class RandomUtilsTest {
    int startInclusive = 0;
    int endInclusive = 9;

    @Test
    @DisplayName("1 ~ 9 사이의 숫자가 생성")
    void nextInt() {
        int testLength = 100_000;

        for (int i = 0; i < testLength; i++) {
            int randomNumber = RandomUtils.nextInt(startInclusive, endInclusive);
            if (randomNumber <= startInclusive || randomNumber > endInclusive) {
                fail();
            }
        }
    }

}