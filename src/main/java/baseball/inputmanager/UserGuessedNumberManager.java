package baseball.inputmanager;

import java.util.Arrays;

import static baseball.StringUtil.END_NUMBER;
import static baseball.StringUtil.NUMBER_OF_DIGITS_OF_NUMBER;
import static baseball.StringUtil.START_NUMBER;

public class UserGuessedNumberManager extends InputManger<Integer[]> {
    private static final int ASCII_VALUE_OF_START_NUMBER = START_NUMBER + '0';
    private static final int ASCII_VALUE_OF_END_NUMBER = END_NUMBER + '0';

    @Override
    boolean meetNumberOfDigitsLimit(String input) {
        return input.length() == NUMBER_OF_DIGITS_OF_NUMBER;
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
