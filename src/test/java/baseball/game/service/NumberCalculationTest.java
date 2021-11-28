package baseball.game.service;

import static baseball.game.message.GuideMessage.*;
import static baseball.game.service.NumberCalculation.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberCalculationTest {

	@Test
	public void 숫자비교_정답테스트() throws Exception {
		assertThat(checkInputNumber(123, 456)).isEqualTo(NOTHING_MESSAGE);
		assertThat(checkInputNumber(123, 156)).isEqualTo("1" + STRIKE_MESSAGE);
		assertThat(checkInputNumber(123, 416)).isEqualTo("1" + BALL_MESSAGE);
		assertThat(checkInputNumber(123, 312)).isEqualTo("3" + BALL_MESSAGE);
		assertThat(checkInputNumber(123, 123)).isEqualTo(WIN_GAME_MESSAGE);
		assertThat(checkInputNumber(123, 321)).isEqualTo(
			"2" + BALL_MESSAGE + " 1" + STRIKE_MESSAGE);
	}
}
