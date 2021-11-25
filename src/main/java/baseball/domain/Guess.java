package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Guess {

    private static final int START_INCLUSIVE = Rule.START_INCLUSIVE.value();
    private static final int END_INCLUSIVE = Rule.END_INCLUSIVE.value();
    private static final int COUNT = Rule.COUNT.value();

    private static final String SIZE_ERROR_MSG = "The length of the user input must be " + COUNT;
    private static final String NOT_NUMERIC_ERROR_MSG = "User input must be a numeric value";
    private static final String DUPLICATE_ERROR_MSG = "All digits must be unique";
    private static final String RANGE_ERROR_MSG =
        "All digits must not be less than " + START_INCLUSIVE
            + " and must not be greater than " + END_INCLUSIVE;

    private final List<Integer> numbers;

    public Guess(String userInput) {
        validateUserInput(userInput);
        this.numbers = toList(userInput);
    }

    private List<Integer> toList(String userInput) {
        ArrayList<Integer> result = new ArrayList<>();
        for (char aChar : userInput.toCharArray()) {
            result.add(Character.getNumericValue(aChar));
        }
        return result;
    }

    private void validateUserInput(String userInput) {
        validateSize(userInput);
        validateIsNumericValue(userInput);
        validateDuplicate(userInput);
        validateRange(userInput);
    }

    private void validateSize(String userInput) {
        if (userInput.length() != COUNT) {
            throw new IllegalArgumentException(SIZE_ERROR_MSG);
        }
    }

    private void validateIsNumericValue(String userInput) {
        for (char c : userInput.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MSG);
            }
        }
    }

    private void validateDuplicate(String userInput) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            set.add(userInput.charAt(i));
        }
        if (set.size() != userInput.length()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MSG);
        }
    }

    private void validateRange(String userInput) {
        for (char c : userInput.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit < START_INCLUSIVE || digit > END_INCLUSIVE) {
                throw new IllegalArgumentException(RANGE_ERROR_MSG);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
