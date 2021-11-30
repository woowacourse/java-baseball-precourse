package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

	private Game game;

	@BeforeEach
	void setUp() {
		List<Integer> computer = Arrays.asList(1, 2, 3);
		game = new Game(computer);
	}

	@DisplayName("사용자가 정답을 맞췄을 때")
	@Test
	void isCorrect() {
		Balls user = new Balls(Arrays.asList(1, 2, 3));
		Hint hint = game.compare(user);
		assertThat(hint.strike() == 3).isTrue();
	}

	@DisplayName("입력한 값이 1, 2인지 검사")
	@Test
	void validateInput() {
		assertThatThrownBy(() -> game.validateInput("3"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("사용자 입력으로 게임 진행 결정")
	@Test
	void choicePlay() {
		game.choicePlay("1");
		assertThat(game.isPlay()).isTrue();
		game.choicePlay("2");
		assertThat(game.isPlay()).isFalse();
	}

}