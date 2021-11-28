package baseball;

import java.util.HashSet;

public class InputBallNumberValidator {

	private static final int BALL_NUMBER_LENGTH = 3;
	private static final char BALL_NUMBER_RANGE_MIN_ASCII = '1';
	private static final char BALL_NUMBER_RANGE_MAX_ASCII = '9';
	private HashSet<Character> inputBallNumbersSet;
	private String inputBallNumbers;

	InputBallNumberValidator(String inputBallNumbers) {
		this.inputBallNumbers = inputBallNumbers;

		inputBallNumbersSet = new HashSet<>();

		checkBallNumbersLength();
		checkBallNumbersRange();
		checkBallNumbersDuplicate();
	}

	public void checkBallNumbersLength() {
		if (inputBallNumbers.length() != BALL_NUMBER_LENGTH) {
			throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
		}
	}

	public void checkBallNumbersRange() {
		for (char number : inputBallNumbers.toCharArray()) {
			if (number < BALL_NUMBER_RANGE_MIN_ASCII || number > BALL_NUMBER_RANGE_MAX_ASCII) {
				throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요.");
			}
		}
	}

	public void checkBallNumbersDuplicate() {
		for (char number : inputBallNumbers.toCharArray()) {
			if (inputBallNumbersSet.contains(number)) {
				throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
			}
			else {
				inputBallNumbersSet.add(number);
			}
		}
	}
}
