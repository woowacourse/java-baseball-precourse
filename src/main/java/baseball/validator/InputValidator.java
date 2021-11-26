package baseball.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.domain.AnswerNumber;

public class InputValidator {
	private List<Integer> inputNumberList;

	public InputValidator(List<Integer> inputNumberList) {
		this.inputNumberList = inputNumberList;
	}

	public boolean validateNumber() {
		return isThreeDigits() && isDigitsInRange() && isNotDuplicated();
	}

	public boolean isThreeDigits() {
		return inputNumberList.size() == AnswerNumber.ANSWER_LENGTH;
	}

	public boolean isDigitsInRange() {
		return inputNumberList
			.stream()
			.allMatch(n -> (n >= AnswerNumber.ANSWER_MIN_VALUE && n <= AnswerNumber.ANSWER_MAX_VALUE));
	}

	public boolean isNotDuplicated() {
		Set<Integer> characterSet = new HashSet<>();
		return inputNumberList
			.stream()
			.allMatch(characterSet::add);
	}
}