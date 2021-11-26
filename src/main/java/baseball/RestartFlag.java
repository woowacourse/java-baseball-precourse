package baseball;

import java.util.Objects;

import com.io.Output;

public class RestartFlag {
	private static final int VALID_INPUT_SIZE = 1;
	private static final int RESTART_NUMBER = 1;
	private static final int STOP_NUMBER = 2;
	private static final char ZERO_CHAR = '0';
	private final int optionNumber;

	public RestartFlag(String optionNumber) {
		isValidNullValue(optionNumber);
		isValidLength(optionNumber);
		this.optionNumber = optionNumber.charAt(0) - ZERO_CHAR;
		isValidFormat(this.optionNumber);
	}

	private void isValidNullValue(String optionNumber) {
		if (Objects.isNull(optionNumber)) {
			throw new IllegalArgumentException(Output.OPTION_NUMBER_NULL_EXCEPTION_MESSAGE);
		}

	}

	private void isValidLength(String optionNumber) {
		if (optionNumber.length() != VALID_INPUT_SIZE) {
			throw new IllegalArgumentException(Output.OPTION_NUMBER_SIZE_EXCEPTION_MESSAGE);
		}

	}

	private void isValidFormat(int optionNumber) {
		if (optionNumber != RESTART_NUMBER && optionNumber != STOP_NUMBER) {
			throw new IllegalArgumentException(Output.OPTION_NUMBER_SIZE_EXCEPTION_MESSAGE);
		}
		
	}

	public boolean isRestart() {
		return optionNumber == RESTART_NUMBER;
	}

}
