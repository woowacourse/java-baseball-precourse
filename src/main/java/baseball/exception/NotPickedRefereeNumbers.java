package baseball.exception;

import baseball.resource.message.ErrorMessage;

public class NotPickedRefereeNumbers extends BaseballException {

    public NotPickedRefereeNumbers() {
        super(ErrorMessage.NOT_PICKED_REFEREE_NUMBERS);
    }

}
