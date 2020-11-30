package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2020/11/27
 */
class BaseballNumberTest {

    @Test
    @DisplayName("일치하는 경우")
    void equalsBaseball() {
        BaseballNumber computer = new BaseballNumber(Arrays.asList(1, 2, 3));
        BaseballNumber player = new BaseballNumber(Arrays.asList(1, 2, 3));

        assertEquals(computer, player);
    }

    @Test
    @DisplayName("3자리의 숫자가 아닐 경우")
    void invalidSize() {
        List<Integer> test1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> test2 = Arrays.asList(1, 2);

        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(test1));
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(test2));
    }
}
