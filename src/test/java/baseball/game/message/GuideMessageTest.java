package baseball.game.message;

import static baseball.game.message.GuideMessage.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GuideMessageTest {

	@Test
	public void 낫싱_메세지() {
		assertThat(NOTHING_MESSAGE).isEqualTo(wrongNumberMessage(0, 0));
	}

	@Test
	public void 낫싱_예외메세지() {
		Exception exception1 = assertThrows(IllegalArgumentException.class,
			() -> nothingMessage(1, 0));
		Exception exception2 = assertThrows(IllegalArgumentException.class,
			() -> nothingMessage(0, 2));

		assertThat(ERR_NOTHING_METHOD_PARAM).isEqualTo(exception1.getMessage());
		assertThat(ERR_NOTHING_METHOD_PARAM).isEqualTo(exception2.getMessage());
	}

	@Test
	public void 볼_메세지() {
		assertThat("1" + BALL_MESSAGE).isEqualTo(wrongNumberMessage(1, 0));
		assertThat("2" + BALL_MESSAGE).isEqualTo(wrongNumberMessage(2, 0));
		assertThat("3" + BALL_MESSAGE).isEqualTo(wrongNumberMessage(3, 0));
	}

	@Test
	public void 볼_예외메세지() {
		Exception exception1 = assertThrows(IllegalArgumentException.class,
			() -> ballOnlyMessage(0, 2));
		Exception exception2 = assertThrows(IllegalArgumentException.class,
			() -> ballOnlyMessage(2, 1));

		assertThat(ERR_BALL_ONLY_METHOD_PARAM).isEqualTo(exception1.getMessage());
		assertThat(ERR_BALL_ONLY_METHOD_PARAM).isEqualTo(exception2.getMessage());
	}

	@Test
	public void 스트라이크_메세지() {
		assertThat("1" + STRIKE_MESSAGE).isEqualTo(wrongNumberMessage(0, 1));
		assertThat("2" + STRIKE_MESSAGE).isEqualTo(wrongNumberMessage(0, 2));
	}

	@Test
	public void 스트라이크_예외메세지() {
		Exception exception1 = assertThrows(IllegalArgumentException.class,
			() -> strikeOnlyMessage(1, 0));
		Exception exception2 = assertThrows(IllegalArgumentException.class,
			() -> strikeOnlyMessage(2, 1));

		assertThat(ERR_STRIKE_ONLY_METHOD_PARAM).isEqualTo(exception1.getMessage());
		assertThat(ERR_STRIKE_ONLY_METHOD_PARAM).isEqualTo(exception2.getMessage());
	}

	@Test
	public void 볼_스트라이크_메세지() {
		assertThat("1" + BALL_MESSAGE + " 1" + STRIKE_MESSAGE).isEqualTo(
			wrongNumberMessage(1, 1));
		assertThat("2" + BALL_MESSAGE + " 1" + STRIKE_MESSAGE).isEqualTo(
			wrongNumberMessage(2, 1));
	}

	@Test
	public void 볼_스트라이크_예외메세지() {
		Exception exception1 = assertThrows(IllegalArgumentException.class, () -> ballAndStrikeMessage(0, 0));
		Exception exception2 = assertThrows(IllegalArgumentException.class, () -> ballAndStrikeMessage(1, 0));
		Exception exception3 = assertThrows(IllegalArgumentException.class, () -> ballAndStrikeMessage(0, 1));
		Exception exception4 = assertThrows(IllegalArgumentException.class, () -> ballAndStrikeMessage(1, 2));
		Exception exception5 = assertThrows(IllegalArgumentException.class, () -> ballAndStrikeMessage(2, 2));
		Exception exception6 = assertThrows(IllegalArgumentException.class, () -> ballAndStrikeMessage(0, 3));

		assertThat(ERR_BALL_STRIKE_METHOD_PARAM).isEqualTo(exception1.getMessage());
		assertThat(ERR_BALL_STRIKE_METHOD_PARAM).isEqualTo(exception2.getMessage());
		assertThat(ERR_BALL_STRIKE_METHOD_PARAM).isEqualTo(exception3.getMessage());
		assertThat(ERR_BALL_STRIKE_METHOD_PARAM).isEqualTo(exception4.getMessage());
		assertThat(ERR_BALL_STRIKE_METHOD_PARAM).isEqualTo(exception5.getMessage());
		assertThat(ERR_BALL_STRIKE_METHOD_PARAM).isEqualTo(exception6.getMessage());
	}

	@Test
	public void 정답_메세지() {
		assertThat(WIN_GAME_MESSAGE)
			.isEqualTo(correctNumberMessage(0, 3));
	}

	@Test
	public void 정답_예외메세지() {
		Exception exception1 = assertThrows(IllegalArgumentException.class,
			() -> correctNumberMessage(1, 0));
		Exception exception2 = assertThrows(IllegalArgumentException.class,
			() -> correctNumberMessage(2, 1));

		assertThat(ERR_CORRECT_NUMBER_PARAM).isEqualTo(exception1.getMessage());
		assertThat(ERR_CORRECT_NUMBER_PARAM).isEqualTo(exception2.getMessage());
	}
}
