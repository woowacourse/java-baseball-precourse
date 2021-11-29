package baseball;

public class Validator {
    public static boolean isValidateGuess(String input) {
        if (input.length() != Constant.DIGIT_NUM) return false;
        if (!isNumberFormat(input)) return false;
        if (!isZeroInNumber(input)) return false;

        return true;
    }

    public static boolean isValidateChoice(String input) {
        if (input.length() != Constant.ONE) return false;
        if (!isNumberFormat(input)) return false;
        if (!isChoiceInRange(input)) return false;

        return true;
    }

    private static boolean isChoiceInRange(String input) {
        return (input.equals(Constant.CHOICE_ONE) || input.equals(Constant.CHOICE_TWO));
    }

    private static boolean isZeroInNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == Constant.LETTER_ZERO) return false;
        }
        return true;
    }

    private static boolean isNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
