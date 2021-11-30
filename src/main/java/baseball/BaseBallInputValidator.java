package baseball;

import static constants.BaseBallConstant.*;

import java.util.HashSet;
import java.util.Set;

public class BaseBallInputValidator {
	public boolean checkUserInput(String userInput) {
		return isRightLength(userInput, NUMBER_LENGTH) && isAllDigit(userInput) && isRightNumberRange(userInput)
			&& isNotDuplicate(userInput);
	}

	public boolean checkUserInputStatus(String userInputStatus) {
		return isRightLength(userInputStatus, 1) && isDigit(userInputStatus) && isRightStatus(userInputStatus);
	}

	private boolean isRightLength(String userInput, Integer number) {
		return userInput.length() == number;
	}

	private boolean isRightNumberRange(String userInput) {
		for (int i = 0; i < 3; i++) {
			if (userInput.charAt(i) - '0' < 1 || 9 < userInput.charAt(i) - '0') {
				return false;
			}
		}
		return true;
	}

	private boolean isAllDigit(String userInput) {
		for (int i = 0; i < 3; i++) {
			char oneDigit = userInput.charAt(i);
			if (!Character.isDigit(oneDigit)) {
				return false;
			}
		}
		return true;
	}

	private boolean isDigit(String userInputStatus) {
		return Character.isDigit(userInputStatus.charAt(0));
	}

	private boolean isNotDuplicate(String userInput) {
		Set<Character> inputDigits = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			inputDigits.add(userInput.charAt(i));
		}
		return inputDigits.size() == 3;
	}

	private boolean isRightStatus(String userInputStatus) {
		return Integer.parseInt(userInputStatus) == GOING || Integer.parseInt(userInputStatus) == STOP;
	}
}
