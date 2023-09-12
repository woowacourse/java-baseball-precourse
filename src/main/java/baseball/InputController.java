package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

import static baseball.constants.ErrorMessages.*;
import static baseball.constants.GameMessages.INPUT_MESSAGE;
import static baseball.constants.InputConstants.*;

public class InputController {

    public static boolean isValidInput(String input) {
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

    public static String getInput() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        while (!isValidInput(input)) {
            System.out.print(INPUT_MESSAGE);
            input = Console.readLine();
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
