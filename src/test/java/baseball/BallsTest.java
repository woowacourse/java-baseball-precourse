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
        Balls balls = Balls.stringToBalls("123");
    }

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

    /** judgeResult()로 Balls 객체끼리 비교해서 알맞은 GameResult를 반환하는지 테스트 */
    @Test
    void judgeResult() {
        Balls myBalls;
        Balls botBalls;
        GameResult gameResult;

        // 3스 0볼
        myBalls = generateBalls(1, 2, 3);
        botBalls = generateBalls(1, 2, 3);
        gameResult = myBalls.judgeResult(botBalls);
        assertEquals(new GameResult(3, 0), gameResult);

        // 0스 3볼
        myBalls = generateBalls(1, 2, 3);
        botBalls = generateBalls(3, 1, 2);
        gameResult = myBalls.judgeResult(botBalls);
        assertEquals(new GameResult(0, 3), gameResult);

        // 1스 1볼
        myBalls = generateBalls(1, 2, 3);
        botBalls = generateBalls(1, 3, 2);
        gameResult = myBalls.judgeResult(botBalls);
        assertEquals(new GameResult(1, 2), gameResult);

        // 0스 0볼
        myBalls = generateBalls(1, 2, 3);
        botBalls = generateBalls(4, 5, 6);
        gameResult = myBalls.judgeResult(botBalls);
        assertEquals(new GameResult(0, 0), gameResult);
    }
}