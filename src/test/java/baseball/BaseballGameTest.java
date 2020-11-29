package baseball;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Judgment;
import baseball.domain.generator.FixedNumbersGenerator;
import baseball.view.OutputView;

public class BaseballGameTest {

    private BaseballGame baseballGame;

    @BeforeEach
    public void initObjects() {
        final Scanner scanner = new Scanner(System.in);
        baseballGame = new BaseballGame(scanner, new FixedNumbersGenerator("123"));
    }

    @Test
    @DisplayName("사용자가 입력한 숫자가 정답일 경우의 테스트")
    public void answerTest() {

        // given, when
        setAndStartRound("123");

        // then
        assertThat(baseballGame.outputView.getResult(baseballGame.scoreBoard))
                .isEqualTo(BaseballGame.BALLS_LENGTH + Judgment.STRIKE.getMessage() +
                        OutputView.GAME_END);
    }

    @Test
    @DisplayName("사용자가 입력한 숫자가 낫싱일 경우의 테스트")
    public void nothingTest() {

        // given, when
        setAndStartRound("456");

        // then
        assertThat(baseballGame.outputView.getResult(baseballGame.scoreBoard))
                .isEqualTo(Judgment.NOTHING.getMessage());
    }

    @Test
    @DisplayName("사용자가 입력한 숫자가 볼만 존재하는 경우의 테스트")
    public void hasOnlyBallsTest() {

        // given, when
        setAndStartRound("531");

        // then
        assertThat(baseballGame.outputView.getResult(baseballGame.scoreBoard))
                .isEqualTo(2 + Judgment.BALL.getMessage());
    }

    @Test
    @DisplayName("사용자가 입력한 숫자가 스트라이크만 존재하는 경우의 테스트")
    public void hasOnlyStrikeTest() {

        // given, when
        setAndStartRound("124");

        // then
        assertThat(baseballGame.outputView.getResult(baseballGame.scoreBoard))
                .isEqualTo(2 + Judgment.STRIKE.getMessage());
    }

    @Test
    @DisplayName("사용자가 입력한 숫자가 스트라이크와 볼이 섞여있는 경우의 테스트")
    public void hasStrikeAndBallTest() {

        // given, when
        setAndStartRound("321");

        // then
        assertThat(baseballGame.outputView.getResult(baseballGame.scoreBoard))
                .isEqualTo(2 + Judgment.BALL.getMessage() + 1 + Judgment.STRIKE.getMessage());
    }

    private void setAndStartRound(String ballNumbers) {

        // given
        baseballGame.setGame();
        baseballGame.setRound(ballNumbers);

        // when
        baseballGame.startRound();
    }
}
