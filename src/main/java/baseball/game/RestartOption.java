package baseball.game;

import java.util.Objects;

import baseball.output.PrintMessage;

public class RestartOption {
	private static final int VALID_INPUT_SIZE = 1;
	private static final int RESTART_NUMBER = 1;
	private static final int STOP_NUMBER = 2;
	private static final char ZERO_CHAR = '0';
	private final int optionNumber;

	public RestartOption(String optionNumber) {
		isValidNullValue(optionNumber);
		isValidLength(optionNumber);
		this.optionNumber = optionNumber.charAt(0) - ZERO_CHAR;
		isValidFormat(this.optionNumber);
	}

	private void isValidNullValue(String optionNumber) {
		if (Objects.isNull(optionNumber)) {
			throw new IllegalArgumentException(PrintMessage.RESTART_NUMBER_NULL_EXCEPTION_MESSAGE.getMessage());
		}

	}

	private void isValidLength(String optionNumber) {
		if (optionNumber.length() != VALID_INPUT_SIZE) {
			throw new IllegalArgumentException(PrintMessage.RESTART_NUMBER_FORMAT_EXCEPTION_MESSAGE.getMessage());
		}

	}

	private void isValidFormat(int optionNumber) {
		if (optionNumber != RESTART_NUMBER && optionNumber != STOP_NUMBER) {
			throw new IllegalArgumentException(PrintMessage.RESTART_NUMBER_FORMAT_EXCEPTION_MESSAGE.getMessage());
		}
		
	}

	public boolean isRestart() {
		return optionNumber == RESTART_NUMBER;
	}

}
