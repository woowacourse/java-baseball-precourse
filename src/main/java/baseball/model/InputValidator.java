package baseball.model;

import static baseball.constants.GameConfig.*;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
	private static final String RANGE_ERROR_MESSAGE = "각 자리 수는 1이상 9이하의 정수입니다.";
	private static final String LENGTH_ERROR_MESSAGE = "세 자리 수를 입력해주세요.";
	private static final String DUPLICATION_ERROR_MESSAGE = "세 자리 수를 입력해주세요.";

	InputValidator() {

	}

	public void validate(String input) {
		validateRange(input);
		validateLength(input);
		validateDuplication(input);
	}

	private void validateRange(String input) {
		String pattern = "[1-9]+";

		if (!input.matches(pattern)) {
			throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
		}
	}

	private void validateLength(String input) {
		if (input.length() != ANSWER_LENGTH) {
			throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
		}
	}

	private void validateDuplication(String input) {
		Set<Character> hashSet = new HashSet<>();
		for (char numChar : input.toCharArray()) {
			hashSet.add(numChar);
		}

		if (hashSet.size() != ANSWER_LENGTH) {
			throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
		}

	}
}
