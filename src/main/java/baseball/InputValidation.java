package baseball;

import java.util.Objects;

public class InputValidation {

    private  static final String ZERO = "0";
    private static final int CORRECT_LENGTH = 3;
    private static final String NUMERIC_FILTER = "[1-9]+";

    private static final String NEW_GAME = "1";
    private static final String EXIT = "2";

    public void validateGuessNumber(String input) {
        validateContainsZero(input);
        validateLength(input);
        validateNumeric(input);
        validateOverlapEachOther(input);
    }

    private void validateOverlapEachOther(String input) {
        if (isOverlapEachOther(input)) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력할 수 있습니다 ! 게임 종료");
        }
    }

    private boolean isOverlapEachOther(String input) {
        return Objects.equals(input.charAt(0), input.charAt(1)) ||
            Objects.equals(input.charAt(0), input.charAt(2)) ||
                Objects.equals(input.charAt(1), input.charAt(2));
    }

    private void validateNumeric(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다 ! 게임 종료");
        }
    }

    private boolean isNumeric(String input) {
        return input.matches(NUMERIC_FILTER);
    }

    private void validateContainsZero(String input) {
        if (isContainsZero(input)) {
            throw new IllegalArgumentException("1 ~ 9 까지의 숫자만 입력할 수 있습니다 ! 게임 종료");
        }
    }

    private boolean isContainsZero(String input) {
        return input.contains(ZERO);
    }

    private void validateLength(String input) {
        if (!isCorrectLength(input)) {
            throw new IllegalArgumentException("세 개의 숫자만 입력할 수 있습니다 ! 게임 종료");
        }
    }

    private boolean isCorrectLength(String input) {
        return Objects.equals(input.length(), CORRECT_LENGTH);
    }

    public void validateNewGameInput(String input) {
        if (!isNewGame(input) && !isExit(input)) {
            throw new IllegalArgumentException("1 혹은 2만 입력할 수 있습니다 ! 게임 종료");
        }
    }

    private boolean isNewGame(String input) {
        return input.equals(NEW_GAME);
    }

    private boolean isExit(String input) {
        return input.equals(EXIT);
    }
}
