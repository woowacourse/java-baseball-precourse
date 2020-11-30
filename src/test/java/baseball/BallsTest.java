package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallsTest {
    public static Balls generateBalls(int... intArr) {
        List<Ball> balls = new ArrayList<>();
        for (int i : intArr) {
            balls.add(new Ball(i));
        }
        return new Balls(balls);
    }

    @Test
    void stringToBalls() {
        // TODO 문자열 -> Balls 변환 잘되는지 어캐 검증하지...
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

    /**
     * judgeResult()로 Balls 객체끼리 비교해서 알맞은 GameResult를 반환하는지 테스트
     */
    @Test
    void judgeResult() {
        Balls myBalls;
        Balls botBalls;
        GameResult gameResult;

        // 3s 0b
        myBalls = generateBalls(1, 2, 3);
        botBalls = generateBalls(1, 2, 3);
        gameResult = myBalls.judgeResult(botBalls);
        assertEquals(new GameResult(3, 0), gameResult);

        // 0s 3b
        myBalls = generateBalls(1, 2, 3);
        botBalls = generateBalls(3, 1, 2);
        gameResult = myBalls.judgeResult(botBalls);
        assertEquals(new GameResult(0, 3), gameResult);

        // 1s 1b
        myBalls = generateBalls(1, 2, 3);
        botBalls = generateBalls(1, 3, 2);
        gameResult = myBalls.judgeResult(botBalls);
        assertEquals(new GameResult(1, 2), gameResult);

        // 0s 0b
        myBalls = generateBalls(1, 2, 3);
        botBalls = generateBalls(4, 5, 6);
        gameResult = myBalls.judgeResult(botBalls);
        assertEquals(new GameResult(0, 0), gameResult);
    }
}