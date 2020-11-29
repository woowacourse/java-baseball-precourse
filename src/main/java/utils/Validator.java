package baseball;

public class Validator {

    protected boolean isValidInputNumbers(String playerInput) {
        if (isValidInputSize(playerInput) && isNumberIntegers(playerInput) && isDifferentNumbers(playerInput))
            return true;
        return false;
    }

    protected boolean isValidMenu(String menuId) {
        int menu = Integer.parseInt(menuId);
        if (menu < 1 || menu  > 2)
            throw new IllegalArgumentException(ExceptionMessage.NOT_VALID_MENU);
        return true;
    }

    private boolean isValidInputSize(String playerInput) {
        if (playerInput.length() > 3)
            throw new IllegalArgumentException(ExceptionMessage.OVER_INPUT_SIZE);
        if (playerInput.length() < 3)
            throw new IllegalArgumentException(ExceptionMessage.UNDER_INPUT_SIZE);
        return true;
    }

    private boolean isNumberIntegers(String playerInput) {
        char[] inputArr = playerInput.toCharArray();
        for (char input : inputArr) {
            if (input < '1' || input > '9')
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
