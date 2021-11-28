package baseball;

import camp.nextstep.edu.missionutils.Console;

public class StartEndButton {
    private static final int NUMBER_OF_DIGITS_OF_INPUT_NUMBERS = 1;
    private static final int ASCII_VALUE_OF_START_NUMBER = '1';
    private static final int ASCII_VALUE_OF_END_NUMBER = '2';

    public int getInput() {
        String input = Console.readLine();
        validateInput(input);
        return stringToArray(input);
    }

    private void validateInput(String input) {
        if (!(meetNumberOfDigitsLimit(input) && meetRangeOfCharacterLimit(input))) {
            throw new IllegalArgumentException();
        }
    }

    private boolean meetNumberOfDigitsLimit(String input) {
        return input.length() == NUMBER_OF_DIGITS_OF_INPUT_NUMBERS;
    }

    private boolean meetRangeOfCharacterLimit(String input) {
        for (Character c : input.toCharArray()) {
            if (ASCII_VALUE_OF_END_NUMBER < c || c < ASCII_VALUE_OF_START_NUMBER) {
                return false;
            }
        }
        return true;
    }

    private int stringToArray(String input) {
        return Integer.parseInt(input);
    }
}
