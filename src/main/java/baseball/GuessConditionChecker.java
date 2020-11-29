package baseball;

public class GuessConditionChecker {
    private GuessConditionChecker() {
    }

    public static boolean checkInputIsNumber(String input) {
        try{
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
