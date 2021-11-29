package baseball.game.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberValidation {

	public static final String INVALID_THREE_DIGIT_NUMBER = "1 ~ 9 범위의 중복되지 않는 숫자로 구성된 3자리수를 입력해주세요";
	public static final String INVALID_SINGLE_DIGIT_NUMBER = "1 또는 2를 입력해주세요";

	public static void validateThreeDigitNumber(String inputString) {

		final String regex = "[1-9]+";

		validateNumber(inputString, regex, INVALID_THREE_DIGIT_NUMBER);
		validateLength(inputString.length(), 3, INVALID_THREE_DIGIT_NUMBER);
		validateDuplication(inputString);
	}

	public static void validateSingleDigitNumber(String inputString) {

		final String regex = "[12]";

		validateNumber(inputString, regex, INVALID_SINGLE_DIGIT_NUMBER);
		validateLength(inputString.length(), 1, INVALID_SINGLE_DIGIT_NUMBER);
	}

	private static void validateNumber(String inputString, String regex, String errorMessage) {
		if (!inputString.matches(regex)) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	private static void validateLength(int inputLength, int requiredLength, String errorMessage) {
		if (inputLength != requiredLength) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	private static void validateDuplication(String inputString) {
		Set<String> inputSet = new HashSet<>(Arrays.asList(inputString.split("")));
		if (inputSet.size() != 3) {
			throw new IllegalArgumentException(INVALID_THREE_DIGIT_NUMBER);
		}
	}
}
