package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BallTest {

    @Test
    public void validateRange_fail() {
        assertThrows(IllegalArgumentException.class, () -> new Ball(-1));
        assertThrows(IllegalArgumentException.class, () -> new Ball(0));
        assertThrows(IllegalArgumentException.class, () -> new Ball(10));

        assertDoesNotThrow(() -> new Ball(9));
        assertDoesNotThrow(() -> new Ball(1));
    }
}