package utils;

public class Validator {
    private static final int GAME_START = 1;
    private static final int SHUTDOWN = 2;
    private static final int NUMBER_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public boolean isValidInputNumber(String playerInput) {
        if (isValidInputSize(playerInput) && isNumberInteger(playerInput) && isDifferentNumbers(playerInput))
            return true;
        return false;
    }

    public boolean isValidMenu(String playerInput) {
        int gameStatus = Integer.parseInt(playerInput);
        if (gameStatus < GAME_START || gameStatus > SHUTDOWN)
            throw new IllegalArgumentException(ExceptionMessage.NOT_VALID_MENU);
        return true;
    }

    private boolean isValidInputSize(String playerInput) {
        if (playerInput.length() > NUMBER_SIZE)
            throw new IllegalArgumentException(ExceptionMessage.OVER_INPUT_SIZE);
        if (playerInput.length() < NUMBER_SIZE)
            throw new IllegalArgumentException(ExceptionMessage.UNDER_INPUT_SIZE);
        return true;
    }

    private boolean isNumberInteger(String playerInput) {
        char[] inputArr = playerInput.toCharArray();
        for (char input : inputArr) {
            int compareValue = input - '0';
            if (compareValue < MIN_NUMBER || compareValue > MAX_NUMBER)
                throw new IllegalArgumentException(ExceptionMessage.NOT_DIGIT);
        }
        return true;
    }

    private boolean isDifferentNumbers(String playerInput) {
        char[] inputArr = playerInput.toCharArray();
        if (inputArr[0] == inputArr[1] || inputArr[0] == inputArr[2] || inputArr[1] == inputArr[2]) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIFFERENT_DIGIT);
        }
        return true;
    }
}
