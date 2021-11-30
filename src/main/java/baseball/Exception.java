package baseball;

public class Exception {
	private static final String LENGTH_EXCEPTION_MESSAGE = "3자리 수를 입력해주세요.";
	private static final String DIGIT_EXCEPTION_MESSAGE = "1부터 9까지 수를 입력해주세요.";
	private static final String DUPLICATE_EXCEPTION_MESSAGE = "중복되지 않는 서로 다른 수를 입력해주세요.";
	private static final String OPTION_EXCEPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	protected static final void validateInputNum(String userInputNum) {
		if (validateSize(userInputNum)) {
			throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
		} else if (validateDigit(userInputNum)) {
			throw new IllegalArgumentException(DIGIT_EXCEPTION_MESSAGE);
		} else if (validateDuplicateNum(userInputNum)) {
			throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
		}
	}

	private static final boolean validateSize(String userInputNum) {
		return userInputNum.length() != 3;
	}

	private static final boolean validateDigit(String userInputNum) {
		for (int i = 0; i < userInputNum.length(); i++) {
			if ((int)userInputNum.charAt(i) < (int)'1' || ((int)'9' < (int)userInputNum.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	private static final boolean validateDuplicateNum(String userInputNum) {
		for (int i = 0; i < userInputNum.length()-1; i++) {
			if(compareDuplicateNum(userInputNum, userInputNum.charAt(i), i)) {
				return true;
			}
		}
		return false;
	}

	private static final boolean compareDuplicateNum(String userInputNum, char compareNum, int index) {
		for (int i = index+1; i < userInputNum.length(); i++) {
			if (userInputNum.charAt(i) == compareNum) {
				return true;
			}
		}
		return false;
	}

	protected static final void validateInputChoice(String userChoice) {
		if (validateChoice(userChoice)) {
			throw new IllegalArgumentException(OPTION_EXCEPTION_MESSAGE);
		}
	}

	private static final boolean validateChoice(String userChoice) {
		if ((int)userChoice.charAt(0) != (int)'1' && (int)userChoice.charAt(0) != (int)'2') {
			return true;
		} else {
			return false;
		}
	}
}
