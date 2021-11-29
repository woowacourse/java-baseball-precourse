package baseball;

import java.util.HashSet;

public class InputValidator {

    private static final String NUMERIC_REGEX = "[1-9]+";

    public void validateGameNumberInput(String input) {
        validateLength(input);
        validateStringIsNumeric(input);
        validateStringContainsZero(input);
        validateStringHasDuplicatedChar(input);
    }

    public void validateRestartGameInput(String input) {
        if (!isReGame(input) && !isExit(input)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(String input) {
        if (input.length() != Computer.NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateStringIsNumeric(String input) {
        if (!input.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateStringContainsZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateStringHasDuplicatedChar(String input) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < Computer.NUMBER_LENGTH; i++) {
            hashSet.add(input.charAt(i) - '0');
        }

        if (hashSet.size() != Computer.NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isReGame(String input) {
        return input.equals(BaseballGame.RE_GAME);
    }

    private boolean isExit(String input) {
        return input.equals(BaseballGame.EXIT);
    }
}