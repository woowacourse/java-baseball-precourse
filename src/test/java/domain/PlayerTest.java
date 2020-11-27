package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2020/11/27
 */
class PlayerTest {

    @Test
    @DisplayName("플레이어의 야구숫자가 생성되는지")
    void createBaseballNumber() {
        Player player = new Player();
        String input = "123";
        BaseballNumber baseballNumber = player.createBaseballNumber(input);

        assertEquals(BaseballNumber.class, baseballNumber.getClass());
    }
}
