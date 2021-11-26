package baseball.domain;

import static baseball.constants.GameConstants.Terminology.*;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
	private Computer computer;
	private Player player;

	@BeforeEach
	void setUp() {
		computer = new Computer(Arrays.asList(1, 2, 3));
	}

	@Test
	void 판정_3_스트라이크() {
		// given, when
		player = new Player(Arrays.asList(1, 2, 3));
		Game game = new Game(computer, player);
		game.runComparison();

		//then
		Assertions.assertThat(game.toString()).isEqualTo(3 + STRIKE.getString());
	}

	@Test
	void 판정_낫싱() {
		// given, when
		player = new Player(Arrays.asList(4, 5, 6));
		Game game = new Game(computer, player);
		game.runComparison();

		//then
		Assertions.assertThat(game.toString()).isEqualTo(NOTHING.getString());
	}

	@Test
	void 판정_1볼() {
		// given, when
		player = new Player(Arrays.asList(4, 1, 6));
		Game game = new Game(computer, player);
		game.runComparison();

		//then
		Assertions.assertThat(game.toString()).isEqualTo(1 + BALL.getString());
	}

	@Test
	void 판정_1볼_1스트라이크() {
		// given, when
		player = new Player(Arrays.asList(4, 1, 3));
		Game game = new Game(computer, player);
		game.runComparison();

		//then
		Assertions.assertThat(game.toString()).isEqualTo(1 + BALL.getString() + ' ' + 1 + STRIKE.getString());
	}

	@Test
	void 판정_3볼() {
		// given, when
		player = new Player(Arrays.asList(3, 1, 2));
		Game game = new Game(computer, player);
		game.runComparison();

		//then
		Assertions.assertThat(game.toString()).isEqualTo(3 + BALL.getString());
	}

	@Test
	void 판정_2볼_1스트라이크() {
		// given, when
		player = new Player(Arrays.asList(1, 3, 2));
		Game game = new Game(computer, player);
		game.runComparison();

		//then
		Assertions.assertThat(game.toString()).isEqualTo(2 + BALL.getString() + ' ' + 1 + STRIKE.getString());
	}
}
