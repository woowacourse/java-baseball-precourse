package utils;

public class Validator {
    private static final int NUMBER_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public void isValidInputNumber(String playerInput) {
        isValidInputSize(playerInput);
        isNumberInteger(playerInput);
        isDifferentNumbers(playerInput);
    }

    public void isValidMenu(String playerInput) {
        if (!playerInput.matches("[1-2]")) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_VALID_MENU);
        }
    }

    private void isValidInputSize(String playerInput) {
        if (playerInput.length() > NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.OVER_INPUT_SIZE);
        }
        if (playerInput.length() < NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.UNDER_INPUT_SIZE);
        }
    }

    private void isNumberInteger(String playerInput) {
        char[] inputArr = playerInput.toCharArray();
        for (char input : inputArr) {
            int compareValue = input - '0';
            if (compareValue < MIN_NUMBER || compareValue > MAX_NUMBER) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGER);
            }
        }
    }

    private void isDifferentNumbers(String playerInput) {
        char[] inputArr = playerInput.toCharArray();
        if (inputArr[0] == inputArr[1] || inputArr[0] == inputArr[2] || inputArr[1] == inputArr[2]) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIFFERENT_DIGIT);
        }
    }
}
