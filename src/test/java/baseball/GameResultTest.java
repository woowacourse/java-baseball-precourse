package baseball;

import static baseball.BallsTest.generateBalls;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void judgeResult() {
        Balls myBalls;
        Balls botBalls;

        // 3s 0b
        myBalls = generateBalls(1, 2, 3);
        botBalls = generateBalls(1, 2, 3);
        assertEquals(
                new GameResult(3, 0),
                GameResult.judgeResult(myBalls, botBalls));

        // 0s 3b
        myBalls = generateBalls(1, 2, 3);
        botBalls = generateBalls(3, 1, 2);
        assertEquals(
                new GameResult(0, 3),
                GameResult.judgeResult(myBalls, botBalls));

        // 1s 1b
        myBalls = generateBalls(1, 2, 3);
        botBalls = generateBalls(1, 3, 2);
        assertEquals(
                new GameResult(1, 2),
                GameResult.judgeResult(myBalls, botBalls));

        // 0s 0b
        myBalls = generateBalls(1, 2, 3);
        botBalls = generateBalls(4, 5, 6);
        assertEquals(
                new GameResult(0, 0),
                GameResult.judgeResult(myBalls, botBalls));
    }


    @Test
    void getResultMessage_strikeAndBall() {
        int strike = 1, ball = 1;
        assertEquals(
                new GameResult(strike, ball).getResultMessage(),
                "1볼 1스트라이크");
    }

    @Test
    void getResultMessage_strike() {
        int strike = 1, ball = 0;
        assertEquals(
                new GameResult(strike, ball).getResultMessage(),
                "1스트라이크");
    }

    @Test
    void getResultMessage_ball() {
        int strike = 0, ball = 1;
        assertEquals(
                new GameResult(strike, ball).getResultMessage(),
                "1볼");
    }
}