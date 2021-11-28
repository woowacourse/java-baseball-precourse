package baseball.inputmanager;

import java.util.Arrays;

public class UserGuessedNumberManager extends InputManger<Integer[]> {
    private static final int NUMBER_OF_DIGITS_OF_INPUT_NUMBERS = 3;
    private static final int ASCII_VALUE_OF_START_NUMBER = '1';
    private static final int ASCII_VALUE_OF_END_NUMBER = '9';

    @Override
    boolean meetNumberOfDigitsLimit(String input) {
        return input.length() == NUMBER_OF_DIGITS_OF_INPUT_NUMBERS;
    }

    @Override
    boolean meetRangeOfCharacterLimit(String input) {
        for (Character c : input.toCharArray()) {
            if (ASCII_VALUE_OF_END_NUMBER < c || c < ASCII_VALUE_OF_START_NUMBER) {
                return false;
            }
        }
        return true;
    }

    @Override
    Integer[] toReturn(String input) {
        return Arrays.stream(input.split("")).map(Integer::parseInt).toArray(Integer[]::new);
    }
}
