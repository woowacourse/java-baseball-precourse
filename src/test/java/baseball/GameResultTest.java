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
    }
}