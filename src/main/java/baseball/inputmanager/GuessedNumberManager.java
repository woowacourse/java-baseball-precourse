package baseball.inputmanager;

import static baseball.StringUtil.*;

import java.util.Arrays;

public class GuessedNumberManager extends InputManger<Integer[]> {

    @Override
    boolean isRightLength(String input) {
        return input.length() == NUMBER_OF_DIGITS_OF_GAME_NUMBER;
    }

    @Override
    boolean isRightCharacterRange(String input) {
        for (Character c : input.toCharArray()) {
            if (ASCII_VALUE_OF_MAX_GAME_NUMBER < c || c < ASCII_VALUE_OF_MIN_GAME_NUMBER) {
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
