package baseball.exception;

import baseball.resource.message.ErrorMessage;

public class InputOutOfOptionsMessageException extends BaseballException {
    public InputOutOfOptionsMessageException() {
        super(ErrorMessage.INPUT_OUT_OF_OPTIONS_MESSAGE);
    }
}
