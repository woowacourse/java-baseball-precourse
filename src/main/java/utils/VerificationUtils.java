package utils;

public class VerificationUtils {
    private static final String ERROR_MESSAGE = "잘못 입력하셨습니다.";
    private static final int GUESS_NUMBER_LENGTH = 3;
    private static final int PROGRESS_NUMBER_LENGTH = 1;

    private VerificationUtils() {
    }

    public static void verifyGuess(String GuessNumber) {
        try {
            Integer.parseInt(GuessNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        if (GuessNumber.length() != GUESS_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        char firstNumber = GuessNumber.charAt(0);
        char secondNumber = GuessNumber.charAt(1);
        char thirdNumber = GuessNumber.charAt(2);

        if ((firstNumber == '0') || (secondNumber == '0') || (thirdNumber == '0')) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        if ((firstNumber == secondNumber) || (secondNumber == thirdNumber) || (thirdNumber == firstNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void verifyProgress(String ProgressNumber) {
        try {
            Integer.parseInt(ProgressNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        if (ProgressNumber.length() != PROGRESS_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        char firstNumber = ProgressNumber.charAt(0);

        if ((firstNumber != '1') && (firstNumber != '2')) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
