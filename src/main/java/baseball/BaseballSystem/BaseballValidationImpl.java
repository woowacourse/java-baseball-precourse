package baseball.BaseballSystem;

import baseball.BaseballGame;
import java.util.regex.Pattern;

public class BaseballValidationImpl implements Validation {

    public static final BaseballValidationImpl VALIDATION_IMPL = new BaseballValidationImpl();

    private static final Pattern isNumericPattern = Pattern.compile("^[1-9]*$");

    private BaseballValidationImpl() {}

    public static BaseballValidationImpl getInstance() {
        return VALIDATION_IMPL;
    }

    @Override
    public String isValidInput(final String input) {
        if (isLimitedLength(input) && isNumeric(input)) {
            return input;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String isValidContinueInput(final String input) {
        if (continueGame(input) || endGame(input)) {
            return input;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean endGame(final String input) {
        return BaseballRule.END_GAME.getValue().equals(input);
    }

    private boolean continueGame(final String input) {
        return BaseballRule.CONTINUE_GAME.getValue().equals(input);
    }

    private boolean isNumeric(final String input) {
        return isNumericPattern.matcher(input).matches();
    }

    private boolean isLimitedLength(final String input) {
        return input.length() == Integer.parseInt(BaseballRule.INPUT_VALIDATION_LENGTH.getValue());
    }
}
