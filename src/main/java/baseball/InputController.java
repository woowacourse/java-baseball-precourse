package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

import static baseball.constants.ErrorMessages.*;
import static baseball.constants.InputConstants.*;

public class InputController {

    public static boolean isValidInput(String input) throws IllegalArgumentException {
        HashSet<Character> set = new HashSet<>();
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (input.charAt(i) < (char)(MIN_NUMBER + '0') || input.charAt(i) > (char)(MAX_NUMBER + '0')) {
                throw new IllegalArgumentException(INVALID_NUMBER);
            } else if (!set.add(input.charAt(i))) {
                throw new IllegalArgumentException(DUPLICATED_NUMBER);
            }
        }
        return true;
    }

    public static String getInput() throws IllegalArgumentException {
        String input = Console.readLine();
        try {
           if (isValidInput(input))
               return input;
        } catch (IllegalArgumentException e) {
           throw new IllegalArgumentException(e.getMessage());
        }
        return input;
    }

    public static String getRestart() throws IllegalArgumentException {
        String input = Console.readLine();
        if (input.equals("1") || input.equals("2")) {
            return input;
        } else throw new IllegalArgumentException(INVALID_RESTART_COMMAND);
    }
}
