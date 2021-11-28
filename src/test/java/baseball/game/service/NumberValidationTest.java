package baseball.game.service;

import static baseball.game.service.NumberValidation.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberValidationTest {

	@Test
	public void 세자리수_검증() {
		Exception ex1 = assertThrows(IllegalArgumentException.class, () -> validateThreeDigitNumber("1 3"));
		Exception ex2 = assertThrows(IllegalArgumentException.class, () -> validateThreeDigitNumber("   "));
		Exception ex3 = assertThrows(IllegalArgumentException.class, () -> validateThreeDigitNumber("1/3"));
		Exception ex4 = assertThrows(IllegalArgumentException.class, () -> validateThreeDigitNumber("1a3"));
		Exception ex5 = assertThrows(IllegalArgumentException.class, () -> validateThreeDigitNumber("103"));
		Exception ex6 = assertThrows(IllegalArgumentException.class, () -> validateThreeDigitNumber("133"));
		Exception ex7 = assertThrows(IllegalArgumentException.class, () -> validateThreeDigitNumber("1234"));
		Exception ex8 = assertThrows(IllegalArgumentException.class, () -> validateThreeDigitNumber("13"));
		Exception ex9 = assertThrows(IllegalArgumentException.class, () -> validateThreeDigitNumber(""));

		assertThat(INVALID_THREE_DIGIT_NUMBER).isEqualTo(ex1.getMessage());
		assertThat(INVALID_THREE_DIGIT_NUMBER).isEqualTo(ex2.getMessage());
		assertThat(INVALID_THREE_DIGIT_NUMBER).isEqualTo(ex3.getMessage());
		assertThat(INVALID_THREE_DIGIT_NUMBER).isEqualTo(ex4.getMessage());
		assertThat(INVALID_THREE_DIGIT_NUMBER).isEqualTo(ex5.getMessage());
		assertThat(INVALID_THREE_DIGIT_NUMBER).isEqualTo(ex6.getMessage());
		assertThat(INVALID_THREE_DIGIT_NUMBER).isEqualTo(ex7.getMessage());
		assertThat(INVALID_THREE_DIGIT_NUMBER).isEqualTo(ex8.getMessage());
		assertThat(INVALID_THREE_DIGIT_NUMBER).isEqualTo(ex9.getMessage());
	}

	@Test
	public void 한자리수_검증() {
		Exception ex1 = assertThrows(IllegalArgumentException.class, () -> validateSingleDigitNumber(" "));
		Exception ex2 = assertThrows(IllegalArgumentException.class, () -> validateSingleDigitNumber("/"));
		Exception ex3 = assertThrows(IllegalArgumentException.class, () -> validateSingleDigitNumber(""));
		Exception ex4 = assertThrows(IllegalArgumentException.class, () -> validateSingleDigitNumber("a"));
		Exception ex5 = assertThrows(IllegalArgumentException.class, () -> validateSingleDigitNumber("0"));
		Exception ex6 = assertThrows(IllegalArgumentException.class, () -> validateSingleDigitNumber("12"));
		Exception ex7 = assertThrows(IllegalArgumentException.class, () -> validateSingleDigitNumber("1a"));
		Exception ex8 = assertThrows(IllegalArgumentException.class, () -> validateSingleDigitNumber("&"));

		assertThat(INVALID_SINGLE_DIGIT_NUMBER).isEqualTo(ex1.getMessage());
		assertThat(INVALID_SINGLE_DIGIT_NUMBER).isEqualTo(ex2.getMessage());
		assertThat(INVALID_SINGLE_DIGIT_NUMBER).isEqualTo(ex3.getMessage());
		assertThat(INVALID_SINGLE_DIGIT_NUMBER).isEqualTo(ex4.getMessage());
		assertThat(INVALID_SINGLE_DIGIT_NUMBER).isEqualTo(ex5.getMessage());
		assertThat(INVALID_SINGLE_DIGIT_NUMBER).isEqualTo(ex6.getMessage());
		assertThat(INVALID_SINGLE_DIGIT_NUMBER).isEqualTo(ex7.getMessage());
		assertThat(INVALID_SINGLE_DIGIT_NUMBER).isEqualTo(ex8.getMessage());
	}
}
