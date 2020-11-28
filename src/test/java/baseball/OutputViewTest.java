package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.OutputView.BALL;
import static baseball.OutputView.GAME_END;
import static baseball.OutputView.NOTHING;
import static baseball.OutputView.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.ScoreBoard;

public class OutputViewTest {

    @Test
    @DisplayName("낫싱 반환 테스트")
    public void nothingTest() {
        ScoreBoard scoreBoard = new ScoreBoard(0, 0);
        OutputView outputView = new OutputView();
        assertThat(outputView.getResult(scoreBoard)).isEqualTo(NOTHING);
    }

    @Test
    @DisplayName("스트라이크가 0이고 볼이 0이 아닐 경우 반환 테스트")
    public void hasZeroStrikeTest() {
        ScoreBoard scoreBoard = new ScoreBoard(0, 1);
        OutputView outputView = new OutputView();
        assertThat(outputView.getResult(scoreBoard)).isEqualTo(1 + BALL);
    }

    @Test
    @DisplayName("스트라이크가 0이 아니고 볼이 0일 경우 반환 테스트")
    public void hasZeroBallTest() {
        ScoreBoard scoreBoard = new ScoreBoard(1, 0);
        OutputView outputView = new OutputView();
        assertThat(outputView.getResult(scoreBoard)).isEqualTo(1 + STRIKE);
    }

    @Test
    @DisplayName("정답일 경우 반환 테스트")
    public void answerTest() {
        ScoreBoard scoreBoard = new ScoreBoard(3, 0);
        OutputView outputView = new OutputView();
        assertThat(outputView.getResult(scoreBoard)).isEqualTo(3 + STRIKE + GAME_END);
    }
}
