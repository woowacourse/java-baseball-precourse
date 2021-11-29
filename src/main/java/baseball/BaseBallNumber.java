package baseball;

import static baseball.Constants.*;
import static resource.MessageResource.*;

import util.InputValidationUtils;

public class BaseBallNumber {
	private final String ballNumber;

	public BaseBallNumber(String ballNumber) {
		if (!InputValidationUtils.isCheckValid(ballNumber)) {
			throw new IllegalArgumentException(ERROR_INPUT_NUMBER);
		}
		this.ballNumber = ballNumber;
	}

	public String getBallNumber() {
		return ballNumber;
	}

}
