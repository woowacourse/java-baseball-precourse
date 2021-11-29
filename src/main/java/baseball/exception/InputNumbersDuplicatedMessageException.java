package baseball.exception;

import baseball.resource.message.ErrorMessage;

public class InputNumbersDuplicatedMessageException extends BaseballException {

    public InputNumbersDuplicatedMessageException() {
        super(ErrorMessage.INPUT_NUMBERS_DUPLICATED_MESSAGE);
    }

}
