package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BallsTest {

    @Test
    void validateSize() {
        assertThrows(IllegalArgumentException.class, () -> Balls.stringToBalls("1234"));
        assertThrows(IllegalArgumentException.class, () -> Balls.stringToBalls("12"));
        assertThrows(IllegalArgumentException.class, () -> Balls.stringToBalls(""));
        assertDoesNotThrow(() -> Balls.stringToBalls("123"));
    }

    @Test
    void validateDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> Balls.stringToBalls("111"));
        assertThrows(IllegalArgumentException.class, () -> Balls.stringToBalls("999"));
        assertDoesNotThrow(() -> Balls.stringToBalls("123"));
        assertDoesNotThrow(() -> Balls.stringToBalls("159"));
    }
}