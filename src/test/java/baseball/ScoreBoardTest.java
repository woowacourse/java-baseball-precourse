package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.Judgment;
import baseball.domain.ScoreBoard;

public class ScoreBoardTest {

    private ScoreBoard scoreBoard;

    @BeforeEach
    public void initScoreBoard() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    @DisplayName("Judgment.STRIKE일 경우 strike 1 증가")
    public void increaseStrikeTest() {
        scoreBoard.record(Judgment.STRIKE);
        assertThat(scoreBoard.getStrike()).isEqualTo(1);
        assertThat(scoreBoard.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("Judgment.BALL일 경우 ball 1 증가")
    public void increaseBallTest() {
        scoreBoard.record(Judgment.BALL);
        assertThat(scoreBoard.getStrike()).isEqualTo(0);
        assertThat(scoreBoard.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크가 0개일 경우 hasZeroStrike() true 반환 테스트")
    public void hasZeroStrikeTest() {
        assertTrue(scoreBoard.hasZeroStrike());
    }

    @Test
    @DisplayName("스트라이크가 1개일 경우 hasZeroStrike() false 반환 테스트")
    public void hasOneStrikeTest() {
        scoreBoard = new ScoreBoard(1, 0);
        assertFalse(scoreBoard.hasZeroStrike());
    }

    @Test
    @DisplayName("볼이 0개일 경우 hasZeroBall() true 반환 테스트")
    public void hasZeroBallTest() {
        assertTrue(scoreBoard.hasZeroBall());
    }

    @Test
    @DisplayName("볼이 0개일 경우 hasZeroBall() false 반환 테스트")
    public void hasOneBallTest() {
        scoreBoard = new ScoreBoard(0, 1);
        assertFalse(scoreBoard.hasZeroBall());
    }

    @Test
    @DisplayName("3스트라이크일 경우 isAnswer() true 반환 테스트")
    public void hasThreeStrikeAnswerTest() {
        scoreBoard = new ScoreBoard(3, 0);
        assertTrue(scoreBoard.isAnswer());
    }

    @Test
    @DisplayName("2스트라이크일 경우 isAnswer() false 반환 테스트")
    public void hasTwoStrikeAnswerTest() {
        scoreBoard = new ScoreBoard(2, 0);
        assertFalse(scoreBoard.isAnswer());
    }
}
