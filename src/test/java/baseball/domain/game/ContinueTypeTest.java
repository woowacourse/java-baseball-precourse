package baseball.domain.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContinueTypeTest {

	@Test
	@DisplayName("1 입력은 참을 반환해야 한다.")
	public void testContinueWIthOne() throws Exception {
		// given
		String input = "1";
		// when
		boolean isContinue = ContinueType.toBeContinued(input);
		// then
		Assertions.assertTrue(isContinue);
	}

	@Test
	@DisplayName("2 입력은 거짓을 반환해야 한다.")
	public void testContinueWithTwo() throws Exception {
		String input = "2";
		// when
		boolean isContinue = ContinueType.toBeContinued(input);
		// then
		Assertions.assertFalse(isContinue);
	}

	@Test
	@DisplayName("1, 2 이외의 값은 예외를 던져야 한다.")
	public void testContinueWithElse() throws Exception {
		// given
		String input = "12";
		//then
		Assertions.assertThrows(IllegalArgumentException.class, () -> ContinueType.toBeContinued(input));
	}
}
