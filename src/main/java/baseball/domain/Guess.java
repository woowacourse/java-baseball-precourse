package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Guess {

    private final int startInclusive;
    private final int endInclusive;
    private final int count;
    private final List<Integer> guess;

    public Guess(String userInput, int startInclusive, int endInclusive, int count) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        this.count = count;
        validateUserInput(userInput);
        this.guess = toList(userInput);
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
        if (userInput.length() != count) {
            throw new IllegalArgumentException("The length of the user input must be " + count);
        }
    }

    private void validateIsNumericValue(String userInput) {
        for (char c : userInput.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("User input should be a numeric value");
            }
        }
    }

    private void validateDuplicate(String userInput) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            set.add(userInput.charAt(i));
        }
        if (set.size() != userInput.length()) {
            throw new IllegalArgumentException("All digits should be unique");
        }
    }

    private void validateRange(String userInput) {
        for (char c : userInput.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit < 1 || digit > 9) {
                throw new IllegalArgumentException(
                    "All digits should not be less than " + startInclusive
                        + " and should not be greater than " + endInclusive);
            }
        }
    }
}
