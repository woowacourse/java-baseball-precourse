package baseball.domain.ball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBallSetInputValidatorTest {

	@Test
	@DisplayName("사용자 입력 숫자의 개수는 3개여야 한다")
	public void testUserGeneratedNumberBallLength() throws Exception {
		// given
		String input = "1234";

		// then
		assertThrows(IllegalArgumentException.class, () -> NumberBallSetInputValidator.validateAll(input));
	}

	@Test
	@DisplayName("사용자 입력 숫자는 중복되어서는 안된다")
	public void testUserGeneratedNumberBallUnique() throws Exception {
		// given
		String input = "122";

		// then
		assertThrows(IllegalArgumentException.class, () -> NumberBallSetFactory.generateNumbersFromInput(input));
	}

	@Test
	@DisplayName("사용자 입력에 문자가 들어가서는 안된다")
	public void testUserGeneratedNumberBallDigit() throws Exception {
		// given
		String input = "1ab";

		// then
		assertThrows(IllegalArgumentException.class, () -> NumberBallSetInputValidator.validateAll(input));
	}
}
