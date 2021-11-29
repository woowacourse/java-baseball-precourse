package baseball.exception;

import baseball.resource.message.ErrorMessage;

public class InputNumbersNotMatchDigitsMessageException extends BaseballException {

	public InputNumbersNotMatchDigitsMessageException() {
		super(ErrorMessage.INPUT_NUMBERS_NOT_MATCH_DIGITS_MESSAGE);
	}

}
