package baseball.validator;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import baseball.domain.AnswerNumber;

public class InputValidator {
	private String inputNumber;

	public InputValidator(String inputNumber) {
		this.inputNumber = inputNumber;
	}

	public boolean validateNumber() {
		return isThreeDigits() && isDigitsInRange() && isNotDuplicated();
	}

	public boolean isThreeDigits() {
		return inputNumber.length() == AnswerNumber.ANSWER_LENGTH;
	}

	public boolean isDigitsInRange() {
		return Stream.of(inputNumber.split(""))
			.map(Integer::parseInt)
			.allMatch(n -> (n >= AnswerNumber.ANSWER_MIN_VALUE && n <= AnswerNumber.ANSWER_MAX_VALUE));
	}

	public boolean isNotDuplicated() {
		Set<String> characterSet = new HashSet<>();
		return Stream.of(inputNumber.split(""))
			.allMatch(characterSet::add);
	}
}