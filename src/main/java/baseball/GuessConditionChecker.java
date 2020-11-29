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

    public static boolean checkThreeDigitNumber(int number) {
        if (number > 99 && number < 1000) {
            return true;
        }
        return false;
    }
}
