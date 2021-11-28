package baseball;

import constant.CurrentState;
import constant.SystemMessage;

public class PredictInput extends PlayerInput {
    private CurrentState state = CurrentState.PLAYING;

    @Override
    boolean isSatisfiedBy(CurrentState status) {
        return this.state == status;
    }

    @Override
    void printInputMessage() {
        System.out.printf("%s", SystemMessage.ENTER_NUMBER_MESSAGE);
    }

    @Override
    void isValidInput(String userInput) {
        int value = Validation.isRightDigit(userInput);
        Validation.isValidRange(value);
        Validation.containZero(value);
    }

}
