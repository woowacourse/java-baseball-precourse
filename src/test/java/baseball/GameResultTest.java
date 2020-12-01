package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void getResult_strikeAndBall() {
        int strike = 1, ball = 1;
        assertEquals(
                new GameResult(strike, ball).getResultMessage(),
                strike + "스트라이크 " + ball + "볼");
    }

    @Test
    void getResult_strike() {
        int strike = 1, ball = 0;
        assertEquals(
                new GameResult(strike, ball).getResultMessage(),
                strike + "스트라이크");
    }

    @Test
    void getResult_ball() {
        int strike = 0, ball = 1;
        assertEquals(
                new GameResult(strike, ball).getResultMessage(),
                ball + "볼");
    }
}