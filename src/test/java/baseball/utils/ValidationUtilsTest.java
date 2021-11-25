package baseball.utils;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationUtilsTest {

	@Test
	void 난수_중복() {
		// given, when
		List<Integer> randomNumberList = Arrays.asList(1, 1, 2);

		// then
		Assertions.assertThat(ValidationUtils.validateRandomDigitsDuplicate(randomNumberList)).isFalse();
	}

	@Test
	void 난수_길이_4() {
		// given, when
		List<Integer> randomNumberList = Arrays.asList(1, 2, 3, 4);

		// then
		Assertions.assertThat(ValidationUtils.validateRandomDigitsLength(randomNumberList)).isFalse();
	}

	@Test
	void 유저_숫자_길이_4() {
		// given, when
		String userInputNumberString = "1234";

		// then
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			ValidationUtils.validateUserInputDigitsLength(userInputNumberString);
		});
	}

	@Test
	void 유저_입력_0() {
		// given, when
		String userInputNumberString = "120";

		// then
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			ValidationUtils.validateUserInputDigitsInRange(userInputNumberString);
		});
	}

	@Test
	void 유저_입력_문자() {
		// given, when
		String userInputNumberString = "a12";

		// then
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			ValidationUtils.validateUserInputDigitsInRange(userInputNumberString);
		});
	}

	@Test
	void 유저_입력_중복() {
		// given, when
		String userInputNumberString = "112";
		List<Integer> userInputNumberList = ConversionUtils.userInputStringToIntegerList(userInputNumberString);

		// then
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			ValidationUtils.validateUserInputDigitListDuplicate(userInputNumberList);
		});
	}
}