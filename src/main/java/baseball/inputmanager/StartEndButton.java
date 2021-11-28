package baseball.inputmanager;

import static baseball.StringUtil.START;
import static baseball.StringUtil.END;

public class StartEndButton extends InputManger<Integer> {
    private static final int NUMBER_OF_DIGITS_OF_INPUT_NUMBERS = 1;

    @Override
    boolean meetNumberOfDigitsLimit(String input) {
        return input.length() == NUMBER_OF_DIGITS_OF_INPUT_NUMBERS;
    }

    @Override
    boolean meetRangeOfCharacterLimit(String input) {
        int integerInput = Integer.parseInt(input);
        return (integerInput == START) || (integerInput == END);
    }

    @Override
    Integer toReturn(String input) {
        return Integer.parseInt(input);
    }
}
