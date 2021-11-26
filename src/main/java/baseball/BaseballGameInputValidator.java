package baseball;

public class BaseballGameInputValidator {

    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final String BASEBALL_GAME_LENGTH_EXCEPTION_MESSAGE = "3자리 수를 입력해주세요.";
    private static final String BASEBALL_GAME_DIGIT_EXCEPTION_MESSAGE = "1부터 9사이의 수를 입력해주세요.";
    private static final String BASEBALL_GAME_CODE_EXCEPTION_MESSAGE = "1과 2 중 하나의 수를 입력해주세요.";

    public void validateNumber(String numbers) {
        if (!validateLength(numbers)) {
            throw new IllegalArgumentException(BASEBALL_GAME_LENGTH_EXCEPTION_MESSAGE);
        }
        if (!validateDigit(numbers)) {
            throw new IllegalArgumentException(BASEBALL_GAME_DIGIT_EXCEPTION_MESSAGE);
        }
    }

    private boolean validateLength(String numbers) {
        return numbers.length() == BASEBALL_GAME_NUMBER_LENGTH;
    }

    private boolean validateDigit(String numbers) {
        for (char number : numbers.toCharArray()) {
            if (number < '1' || number > '9') {
                return false;
            }
        }
        return true;
    }

    public void validateCode(int code) {
        if (code != 1 && code != 2) {
            throw new IllegalArgumentException(BASEBALL_GAME_CODE_EXCEPTION_MESSAGE);
        }
    }
}
