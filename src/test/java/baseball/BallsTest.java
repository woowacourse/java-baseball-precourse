package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class BallsTest {

    public static Balls generateBalls(int... intArr) {
        return new Balls(
                Arrays.stream(intArr)
                        .mapToObj(Ball::new)
                        .collect(Collectors.toList())
        );
    }

    @Test
    void stringToBalls() {
        assertThrows(IllegalArgumentException.class, () -> Balls.stringToBalls(""));
        assertEquals(Balls.stringToBalls("123"), generateBalls(1, 2, 3));
    }

    @Test
    void validateSuccess() {
        assertDoesNotThrow(() -> generateBalls(1, 2, 3));
    }

    @Test
    void validateSize() {
        assertThrows(IllegalArgumentException.class, () -> generateBalls(1, 2, 3, 4));
        assertThrows(IllegalArgumentException.class, () -> generateBalls(1, 2));
        assertThrows(IllegalArgumentException.class, () -> generateBalls());
    }

    @Test
    void validateDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> generateBalls(1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> generateBalls(1, 1, 9));
        assertThrows(IllegalArgumentException.class, () -> generateBalls(9, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> generateBalls(1, 9, 1));
    }
}