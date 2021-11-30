package baseball.inputmanager;

import static baseball.StringUtil.*;

public class StartEndButton extends InputManger<Integer> {

    @Override
    boolean isRightLength(String input) {
        return input.length() == NUMBER_OF_DIGITS_OF_START_END_BUTTON;
    }

    @Override
    boolean isRightCharacterRange(String input) {
        int integerInput = Integer.parseInt(input);
        return (integerInput == START_BUTTON) || (integerInput == END_BUTTON);
    }

    @Override
    Integer toReturn(String input) {
        return Integer.parseInt(input);
    }
}
