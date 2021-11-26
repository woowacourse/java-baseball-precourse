package baseball;

public class BaseballGameInputValidator {

    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;

    public void validateNumber(String numbers) {
        if (!validateLength(numbers)) {
            throw new IllegalArgumentException("3자리 수를 입력해주세요.");
        }
        if (!validateDigit(numbers)) {
            throw new IllegalArgumentException("1부터 9사이의 수를 입력해주세요.");
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
}
