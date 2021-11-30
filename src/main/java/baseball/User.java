package baseball;

import java.util.ArrayList;
import java.util.Objects;

import static baseball.Message.ERROR;
import static baseball.Message.LENGTH_OF_ANSWER;

public class User {
    private static final String ZERO = "0";
    private static final String NUMERIC_FILTER = "[1-9]+";
    private final ArrayList<Integer> userNumbers = new ArrayList<>();

    public User(String input) {
        checkInputNumber(input);
        convertInputNumber(input);
    }

    public void checkInputNumber(String input) {
        checkContainsZero(input);
        checkLength(input);
        checkNumeric(input);
        checkDuplicate(input);
    }

    private void checkNumeric(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ERROR);
        }
    }

    private boolean isNumeric(String input) {
        return input.matches(NUMERIC_FILTER);
    }

    private void checkContainsZero(String input) {
        if (ContainsZERO(input)) {
            throw new IllegalArgumentException(ERROR);
        }
    }

    private boolean ContainsZERO(String input) {

        return input.contains(ZERO);
    }

    private void checkLength(String input) {
        if (!inputNumberLength(input)) {
            throw new IllegalArgumentException(ERROR);
        }
    }

    private boolean inputNumberLength(String input) {
        return Objects.equals(input.length(), LENGTH_OF_ANSWER);
    }

    private void checkDuplicate(String input) {
        if (inputDuplicate(input)) {
            throw new IllegalArgumentException(ERROR);
        }
    }

    private boolean inputDuplicate(String input) {
        return Objects.equals(input.charAt(0), input.charAt(1)) ||
                Objects.equals(input.charAt(0), input.charAt(2)) ||
                Objects.equals(input.charAt(1), input.charAt(2));
    }

    public void convertInputNumber(String userInput) {
        String[] splitStr = userInput.split("");
        for (int i = 0; i < splitStr.length; i++) {
            int intStr = Integer.parseInt(splitStr[i]);
            userNumbers.add(intStr);
        }
    }

    public ArrayList<Integer> getUserNumbers() {
        return userNumbers;
    }
}