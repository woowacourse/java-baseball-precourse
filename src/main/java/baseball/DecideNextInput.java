package baseball;

import constant.CurrentState;
import constant.SystemMessage;

public class DecideNextInput extends PlayerInput {
    private CurrentState state = CurrentState.END;

    @Override
    boolean isSatisfiedBy(CurrentState status) {
        return this.state == status;
    }

    @Override
    void printInputMessage() {
        System.out.println(SystemMessage.ENTER_NEXT_GAME_MESSAGE);
    }

    @Override
    void isValidInput(String userInput) {
        int value = Validation.isRightDigit(userInput);
        Validation.isPermittedInput(value);
    }

}
