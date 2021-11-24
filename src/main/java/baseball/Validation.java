package baseball;

public class Validation {

    public static boolean checkInput(String numbers) {
        return isLengthOk(numbers) && isInteger(numbers) && isUnique(numbers);
    }

    private static boolean isLengthOk(String numbers) {
        if (numbers.length() != Rules.NUMBER_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_LENGTH);
        }
        return true;
    }

    private static boolean isInteger(String numbers) {
        for (int i = 0; i < Rules.NUMBER_LENGTH; i++) {
            if (!Character.isDigit(numbers.charAt(i)) && numbers.charAt(i) != 0) {
                throw new IllegalArgumentException(Message.ERROR_INPUT_TYPE);
            }
        }
        return true;
    }

    private static boolean isUnique(String numbers) {
    }
}
