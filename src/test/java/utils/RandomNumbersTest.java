package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        List<Integer> result = RandomNumbers.getInstance(size);

        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("중복 여부")
    void duplicate() {
        int testLength = 1000;
        List<Integer> numbers = RandomNumbers.getInstance(size);

        // 중복되는 숫자가 있다면 사이즈가 감소
        for (int i = 0; i < testLength; i++) {
            Set<Integer> result = new HashSet<>(numbers);

            if (result.size() != size) {
                fail();
            }
        }
    }
}
