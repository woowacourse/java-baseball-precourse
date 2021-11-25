package baseball;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {
    final BaseballGame baseballGame = new BaseballGame("425","456");
    final BaseballGame baseballGame2 = new BaseballGame("425","789");
    final BaseballGame baseballGame3 = new BaseballGame("425","425");

    @Test
    void calcStrike() {
        assert 1 == baseballGame.calcStrike();
        assert 0 == baseballGame2.calcStrike();
        assert 3 == baseballGame3.calcStrike();
    }

    @Test
    void calcBall() {
        assert 1 == baseballGame.calcBall();
        assert 0 == baseballGame2.calcBall();
        assert 0 == baseballGame3.calcBall();
    }

    @Test
    void calcNothing() {
        assert !baseballGame.calcNothing();
        assert baseballGame2.calcNothing();
        assert !baseballGame3.calcNothing();
    }
}