package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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