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

    }

    private static boolean isUnique(String numbers) {
    }
}
