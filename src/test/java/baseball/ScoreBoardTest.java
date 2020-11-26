package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.ScoreBoard;

public class ScoreBoardTest {

    @Test
    @DisplayName("스트라이크가 0개일 경우 hasZeroStrike() true 반환 테스트")
    public void hasZeroStrikeTest() {
        ScoreBoard scoreBoard = new ScoreBoard();
        assertTrue(scoreBoard.hasZeroStrike());
    }

    @Test
    @DisplayName("스트라이크가 1개일 경우 hasZeroStrike() false 반환 테스트")
    public void hasOneStrikeTest() {
        ScoreBoard scoreBoard = new ScoreBoard(1, 0);
        assertFalse(scoreBoard.hasZeroStrike());
    }
}
