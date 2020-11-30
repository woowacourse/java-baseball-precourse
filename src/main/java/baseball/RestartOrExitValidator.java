package baseball;

public class RestartOrExitValidator {

    final static int RIGHT_LENGTH = 1;
    final static int RESTART = 1;
    final static int EXIT = 2;

    public boolean isValid(String input) {
        return isNumeric(input) && isRightLength(input) && isRightInput(input);
    }

    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isRightLength(String input) {
        return input.length() == RIGHT_LENGTH;
    }

    private boolean isRightInput(String input) {
        int inputIntValue = Integer.parseInt(input);

        return inputIntValue == RESTART || inputIntValue == EXIT;
    }
}
