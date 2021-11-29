package baseball.exception;

import baseball.resource.message.ErrorMessage;

public class NumberOutOfRangeMessageException extends BaseballException {

	public NumberOutOfRangeMessageException() {
		super(ErrorMessage.NUMBER_OUT_OF_RANGE_MESSAGE);
	}

}
