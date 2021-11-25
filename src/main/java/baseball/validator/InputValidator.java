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
		return isThreeDigits() && isDigitsInRange() && isDuplicated();
	}

	public boolean isThreeDigits() {
		return inputNumber.length() != AnswerNumber.ANSWER_LENGTH;
	}

	public boolean isDigitsInRange() {
		return Stream.of(inputNumber)
			.map(Integer::parseInt)
			.allMatch(n -> (n >= 1 && n <= 9));
	}

	public boolean isDuplicated() {
		Set<String> characterSet = new HashSet<>();
		return Stream.of(inputNumber)
			.allMatch(characterSet::add);
	}
}