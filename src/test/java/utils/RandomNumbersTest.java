package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
class RandomNumbersTest {
    int size = 3;

    @Test
    @DisplayName("3개의 숫자가 생성")
    void randomNumbers() {
        List<Integer> result = RandomNumbers.valueOf(size);

        assertEquals(3, result.size());
    }
}
