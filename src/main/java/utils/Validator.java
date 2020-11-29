package utils;

import baseball.BaseballManager;
import baseball.GameStatusCode;

public class Validator {
    private static final int PROGRESS_VALUE_SIZE = 1;

    public void validateInputValue(String inputValue) {
        if (inputValue.length() != BaseballManager.BASEBALL_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessages.WRONG_INPUT_VALUE_SIZE);
        }

        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_NUMBER);
        }

        char firstValue = inputValue.charAt(0);
        char secondValue = inputValue.charAt(1);
        char thirdValue = inputValue.charAt(2);

        if (firstValue == '0' || secondValue == '0' || thirdValue == '0') {
            throw new IllegalArgumentException(ExceptionMessages.NOT_ZERO);
        }
        if (firstValue == secondValue || firstValue == thirdValue || secondValue == thirdValue) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_SAME_NUMBER);
        }
    }

    public void validateProgressValue(String inputValue) {
        if (inputValue.length() != PROGRESS_VALUE_SIZE) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_PROGRESS_CODE);
        }

        int inputCode = 0;

        try {
            inputCode = Integer.parseInt(inputValue);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_PROGRESS_CODE);
        }

        if (inputCode != GameStatusCode.RESTART && inputCode != GameStatusCode.EXIT) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_PROGRESS_CODE);
        }
    }
}
