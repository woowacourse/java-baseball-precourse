package baseball.exception;

import baseball.resource.message.ErrorMessage;

public class InputNotIntegerMessageException extends BaseballException {
    public InputNotIntegerMessageException() {
        super(ErrorMessage.INPUT_NOT_INTEGER_MESSAGE);
    }
}
