package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    Balls generateBalls(int... ints) {
        List<Ball> balls = new ArrayList<>();
        for (int i : ints) {
            balls.add(new Ball(i));
        }
        return new Balls(balls);
    }

    @Test
    void judgeResult() {
        Balls myBalls = generateBalls(1, 2, 3);
        Balls botBalls = generateBalls(1, 3, 2);
        myBalls.judgeResult(botBalls).printResult();
    }
}