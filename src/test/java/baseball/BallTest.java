package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    public void 정상범위보다_작은_경우() {
        assertThrows(IllegalArgumentException.class, () -> new Ball(-1));
        assertThrows(IllegalArgumentException.class, () -> new Ball(0));
    }

    @Test
    public void 정상범위보다_큰_경우() {
        assertThrows(IllegalArgumentException.class, () -> new Ball(10));
    }

    @Test
    public void 정상적인_입력인_경우() {
        assertDoesNotThrow(() -> new Ball(9));
        assertDoesNotThrow(() -> new Ball(1));
    }
}