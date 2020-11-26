package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.ScoreBoard;

public class ScoreBoardTest {

    @Test
    @DisplayName("스트라이크가 0개 일경우 hasZeroStrike() true 반환 테스트")
    public void hasZeroStrikeTest() {
        ScoreBoard scoreBoard = new ScoreBoard();
        assertTrue(scoreBoard.hasZeroStrike());
    }
}
