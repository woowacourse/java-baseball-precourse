package baseball.builder;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.utils.ValidationUtils;

class RandomDigitsBuilderTest {

	@Test
	void 난수_생성() {
		// given, when
		List<Integer> randomDigitList = RandomDigitsBuilder.getRandomDigitList();

		// then
		Assertions.assertThat(ValidationUtils.validateRandomDigits(randomDigitList)).isTrue();
		Assertions.assertThat(ValidationUtils.validateRandomDigitsLength(randomDigitList)).isTrue();
	}
}