package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BallsTest {
	private Balls user;

	@BeforeEach
	void setUp() {
		user = new Balls("123");
	}

	@Test
	void 사용자_입력값_변환() {
		assertThat(user.getBalls())
			.containsExactly(
				new Ball(1, 1),
				new Ball(2, 2),
				new Ball(3, 3)
			);
	}

	@ParameterizedTest
	@ValueSource(strings = {"12가", "12", "1234", "122", "102"})
	void 예외처리(String input) {
		assertThatThrownBy(() -> new Balls(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"134:1:1", "123:3:0", "312:0:3", "456:0:0"}, delimiter = ':')
	void 야구공_여러개_비교(String computerNumber, String strikeString, String ballString) {
		int strike = Integer.parseInt(strikeString);
		int ball = Integer.parseInt(ballString);

		Balls computer = new Balls(computerNumber);
		GameResult gameResult = new GameResult(computer, user);

		assertThat(gameResult).isEqualTo(new GameResult(strike, ball));
	}

}
