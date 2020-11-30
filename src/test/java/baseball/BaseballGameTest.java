package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.BaseballNumber;
import domain.Hint;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2020/11/29
 */
class BaseballGameTest {
    BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        BaseballNumber baseballNumber = new BaseballNumber(Arrays.asList(1, 2, 3));
        this.baseballGame = new BaseballGame(baseballNumber);
    }

    @Test
    @DisplayName("정답인 경우")
    void equals() {
        BaseballNumber playerNumber = new BaseballNumber(Arrays.asList(1, 2, 3));

        assertTrue(baseballGame.matchBaseball(playerNumber));
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void strike() {
        BaseballNumber playerNumber1 = new BaseballNumber(Arrays.asList(4, 2, 3));
        BaseballNumber playerNumber2 = new BaseballNumber(Arrays.asList(1, 4, 9));
        Hint hint1 = baseballGame.countStrikeAndBall(playerNumber1);
        Hint hint2 = baseballGame.countStrikeAndBall(playerNumber2);

        assertEquals("2스트라이크", hint1.toString());
        assertEquals("1스트라이크", hint2.toString());
    }

    @Test
    @DisplayName("볼 테스트")
    void ball() {
        BaseballNumber playerNumber = new BaseballNumber(Arrays.asList(3, 1, 2));
        Hint hint = baseballGame.countStrikeAndBall(playerNumber);

        assertEquals("3볼", hint.toString());
    }

    @Test
    @DisplayName("볼, 스트라이크 테스트")
    void ballAndStrike() {
        BaseballNumber playerNumber = new BaseballNumber(Arrays.asList(1, 4, 2));
        Hint hint = baseballGame.countStrikeAndBall(playerNumber);

        assertEquals("1볼 1스트라이크", hint.toString());
    }
}