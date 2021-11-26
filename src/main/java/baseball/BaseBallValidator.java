package baseball;

public class BaseBallValidator {
    public static void validateBaseBallInput(String input) throws IllegalArgumentException {
        if (input.length() != 3 || !isNumeric(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRestart(String input) throws IllegalArgumentException {
        RestartInput.byNumber(input);
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
