package baseball;

public class GuessConditionChecker {
    private GuessConditionChecker() {
    }

    public static boolean checkInputIsInteger(String input) {
        try{
            Integer.parseInt(input);
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

    public static boolean checkGuessCondition(String guess) {
        if (!checkInputIsInteger(guess)) {
            return false;
        }
        int guessNumber = Integer.parseInt(guess);
        if (!checkThreeDigitNumber(guessNumber)) {
            return false;
        }
        return NumberConditionChecker.checkNumberCondition(guessNumber);
    }
}
