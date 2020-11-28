package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Judgment;
import baseball.domain.ScoreBoard;

public class OutputViewTest {

    private OutputView outputView;

    @BeforeEach
    public void initOutputView() {
        outputView = new OutputView();
    }

    @Test
    @DisplayName("낫싱 반환 테스트")
    public void nothingTest() {
        ScoreBoard scoreBoard = new ScoreBoard(0, 0);
        assertThat(outputView.getResult(scoreBoard)).isEqualTo(Judgment.NOTHING.getMessage());
    }

    @Test
    @DisplayName("스트라이크가 0이고 볼이 0이 아닐 경우 반환 테스트")
    public void hasZeroStrikeTest() {
        ScoreBoard scoreBoard = new ScoreBoard(0, 1);
        assertThat(outputView.getResult(scoreBoard)).isEqualTo(1 + Judgment.BALL.getMessage());
    }

    @Test
    @DisplayName("스트라이크가 0이 아니고 볼이 0일 경우 반환 테스트")
    public void hasZeroBallTest() {
        ScoreBoard scoreBoard = new ScoreBoard(1, 0);
        assertThat(outputView.getResult(scoreBoard)).isEqualTo(1 + Judgment.STRIKE.getMessage());
    }

    @Test
    @DisplayName("스트라이크와 볼이 0이 아닐 경우 반환 테스트")
    public void hasStrikeAndBallTest() {
        ScoreBoard scoreBoard = new ScoreBoard(1, 2);
        assertThat(outputView.getResult(scoreBoard))
                .isEqualTo(2 + Judgment.BALL.getMessage() + 1 + Judgment.STRIKE.getMessage());
    }

    @Test
    @DisplayName("정답일 경우 반환 테스트")
    public void answerTest() {
        ScoreBoard scoreBoard = new ScoreBoard(3, 0);
        assertThat(outputView.getResult(scoreBoard))
                .isEqualTo(BaseballGame.BALLS_LENGTH + Judgment.STRIKE.getMessage() +
                        OutputView.GAME_END);
    }
}
