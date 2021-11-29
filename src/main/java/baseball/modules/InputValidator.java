package baseball.modules;

import java.util.HashSet;

public class InputValidator {

	static final int BALL_NUMBERS_LENGTH = 3;
	static final char BALL_NUMBERS_RANGE_MIN = '1';
	static final char BALL_NUMBERS_RANGE_MAX = '9';
	static final String ILLEGAL_BALL_NUMBERS_LENGTH_MESSAGE = "3자리 숫자를 입력해주세요.";
	static final String ILLEGAL_BALL_NUMBERS_RANGE_MESSAGE = "1~9 사이의 숫자를 입력해주세요.";
	static final String ILLEGAL_BALL_NUMBERS_DUPLICATE_MESSAGE = "서로 다른 숫자를 입력해주세요.";
	private static final int RESTART_OR_EXIT_LENGTH = 1;
	private static final String EXIT_CODE = "1";
	private static final String RESTART_CODE = "2";
	static final String ILLEGAL_EXIT_OR_RESTART_LENGTH_MESSAGE = "1자리 숫자를 입력해주세요.";
	static final String ILLEGAL_EXIT_OR_RESTART_RANGE_MESSAGE = "숫자 1 또는 2를 입력해주세요.";
	private HashSet<Character> inputBallNumbersSet;
	private String inputBallNumbers;
	private String inputRestartOrExit;

	public void validateInputBallNumbers(String inputBallNumbers) {
		this.inputBallNumbers = inputBallNumbers;
		inputBallNumbersSet = new HashSet<>();

		checkBallNumbersLength();
		checkBallNumbersRange();
		checkBallNumbersDuplicate();
	}

	private void checkBallNumbersLength() {
		if (inputBallNumbers.length() != BALL_NUMBERS_LENGTH) {
			throw new IllegalArgumentException(ILLEGAL_BALL_NUMBERS_LENGTH_MESSAGE);
		}
	}

	private void checkBallNumbersRange() {
		for (char number : inputBallNumbers.toCharArray()) {
			if (number < BALL_NUMBERS_RANGE_MIN || number > BALL_NUMBERS_RANGE_MAX) {
				throw new IllegalArgumentException(ILLEGAL_BALL_NUMBERS_RANGE_MESSAGE);
			}
		}
	}

	private void checkBallNumbersDuplicate() {
		for (char number : inputBallNumbers.toCharArray()) {
			if (inputBallNumbersSet.contains(number)) {
				throw new IllegalArgumentException(ILLEGAL_BALL_NUMBERS_DUPLICATE_MESSAGE);
			} else {
				inputBallNumbersSet.add(number);
			}
		}
	}

	public void validateInputRestartOrExit(String inputRestartOrExit) {
		this.inputRestartOrExit = inputRestartOrExit;

		checkRestartOrExitLength();
		checkRestartOrExitRange();
	}

	private void checkRestartOrExitLength() {
		if (inputRestartOrExit.length() != RESTART_OR_EXIT_LENGTH) {
			throw new IllegalArgumentException(ILLEGAL_EXIT_OR_RESTART_LENGTH_MESSAGE);
		}
	}

	private void checkRestartOrExitRange() {
		if (!(inputRestartOrExit.equals(EXIT_CODE) || inputRestartOrExit.equals(RESTART_CODE))) {
			throw new IllegalArgumentException(ILLEGAL_EXIT_OR_RESTART_RANGE_MESSAGE);
		}
	}
}
