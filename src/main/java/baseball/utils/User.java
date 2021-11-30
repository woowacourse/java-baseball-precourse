package baseball.utils;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private static final String GUESS_NUMBER_REGEX = "^[1-9]{3}$";

    public static String inputRestartOrNotNumber() {
        return Console.readLine();
    }

    public static String inputGuessNumber() {
        return Console.readLine();
    }

    public static void validateGuessNumber(final String inputGuessNumber) {

        if (!inputGuessNumber.matches(GUESS_NUMBER_REGEX) || checkDuplicateGuessNumber(inputGuessNumber)) {
            throw new IllegalArgumentException();
        }

    }

    private static boolean checkDuplicateGuessNumber(final String inputGuessNumber) {
        boolean checkDuplicate = false;

        final Set<Character> guessNumbers = new HashSet<>();
        char[] guessNumberCharacters = inputGuessNumber.toCharArray();

        for (final char guessNumberCharacter : guessNumberCharacters) {
            guessNumbers.add(guessNumberCharacter);
        }

        if (guessNumbers.size() < 3) {
            checkDuplicate = true;
        }

        return checkDuplicate;
    }
}
