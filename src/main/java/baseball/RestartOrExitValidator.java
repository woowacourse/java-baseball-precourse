package baseball;

public class RestartOrExitValidator {

    static final int RIGHT_LENGTH = 1;
    static final int RESTART = 1;
    static final int EXIT = 2;

    private RestartOrExitValidator(){}

    public static boolean isValid(String input) {
        return isNumeric(input) && isRightLength(input) && isRightInput(input);
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isRightLength(String input) {
        return input.length() == RIGHT_LENGTH;
    }

    private static boolean isRightInput(String input) {
        int inputIntValue = Integer.parseInt(input);

        return inputIntValue == RESTART || inputIntValue == EXIT;
    }
}
