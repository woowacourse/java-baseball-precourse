package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameResultTest {

    @Test
    void getResult() {

        int strike = 1;
        int ball = 1;
        GameResult gameResult = new GameResult(strike, ball);
        String result = gameResult.getResult();
        assertEquals(result, strike + "스트라이크 " + ball + "볼");

        strike = 1;
        ball = 0;
        gameResult = new GameResult(strike, ball);
        result = gameResult.getResult();
        assertEquals(result, strike + "스트라이크");

        strike = 0;
        ball = 1;
        gameResult = new GameResult(strike, ball);
        result = gameResult.getResult();
        assertEquals(result, ball + "볼");
    }
}