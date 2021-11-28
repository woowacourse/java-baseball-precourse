package baseball.game.message;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GuideMessageTest {

	@Test
	public void 낫싱_메세지() {
		assertThat("낫싱").isEqualTo(GuideMessage.wrongNumberMessage(0, 0));
	}

	@Test
	public void 낫싱_예외메세지() {
		Exception exception1 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.nothingMessage(1, 0));
		Exception exception2 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.nothingMessage(0, 2));

		assertThat("낫싱 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception1.getMessage());
		assertThat("낫싱 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception2.getMessage());
	}

	@Test
	public void 볼_메세지() {
		assertThat("1볼").isEqualTo(GuideMessage.wrongNumberMessage(1, 0));
		assertThat("2볼").isEqualTo(GuideMessage.wrongNumberMessage(2, 0));
		assertThat("3볼").isEqualTo(GuideMessage.wrongNumberMessage(3, 0));
	}

	@Test
	public void 볼_예외메세지() {
		Exception exception1 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.ballOnlyMessage(0, 2));
		Exception exception2 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.ballOnlyMessage(2, 1));

		assertThat("볼만 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception1.getMessage());
		assertThat("볼만 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception2.getMessage());
	}

	@Test
	public void 스트라이크_메세지() {
		assertThat("1스트라이크").isEqualTo(GuideMessage.wrongNumberMessage(0, 1));
		assertThat("2스트라이크").isEqualTo(GuideMessage.wrongNumberMessage(0, 2));
	}

	@Test
	public void 스트라이크_예외메세지() {
		Exception exception1 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.strikeOnlyMessage(1, 0));
		Exception exception2 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.strikeOnlyMessage(2, 1));

		assertThat("스트라이크만 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception1.getMessage());
		assertThat("스트라이크만 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception2.getMessage());
	}

	@Test
	public void 볼_스트라이크_메세지() {
		assertThat("1볼 1스트라이크").isEqualTo(GuideMessage.wrongNumberMessage(1, 1));
		assertThat("2볼 1스트라이크").isEqualTo(GuideMessage.wrongNumberMessage(2, 1));
	}

	@Test
	public void 볼_스트라이크_예외메세지() {
		Exception exception1 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.ballAndStrikeMessage(0, 0));
		Exception exception2 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.ballAndStrikeMessage(1, 0));
		Exception exception3 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.ballAndStrikeMessage(0, 1));
		Exception exception4 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.ballAndStrikeMessage(1, 2));
		Exception exception5 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.ballAndStrikeMessage(2, 2));
		Exception exception6 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.ballAndStrikeMessage(0, 3));

		assertThat("볼과 스트라이크 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception1.getMessage());
		assertThat("볼과 스트라이크 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception2.getMessage());
		assertThat("볼과 스트라이크 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception3.getMessage());
		assertThat("볼과 스트라이크 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception4.getMessage());
		assertThat("볼과 스트라이크 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception5.getMessage());
		assertThat("볼과 스트라이크 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception6.getMessage());
	}

	@Test
	public void 정답_메세지() {
		assertThat("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
			.isEqualTo(GuideMessage.correctNumberMessage(0, 3));
	}

	@Test
	public void 정답_예외메세지() {
		Exception exception1 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.correctNumberMessage(1, 0));
		Exception exception2 = assertThrows(IllegalArgumentException.class,
			() -> GuideMessage.correctNumberMessage(2, 1));

		assertThat("정답 메세지 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception1.getMessage());
		assertThat("정답 메세지 출력에 잘못된 인수가 전달되었습니다").isEqualTo(exception2.getMessage());
	}
}
