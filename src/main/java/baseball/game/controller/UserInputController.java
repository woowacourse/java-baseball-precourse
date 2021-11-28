package baseball.game.controller;

import baseball.game.constants.BaseballGameConst;
import camp.nextstep.edu.missionutils.Console;

import static baseball.game.constants.BaseballGameConst.*;

public class UserInputController {

    public UserInputController() {

    }


    public static int[] getUserInput() {
        String input = Console.readLine();
        validateInput(input);
        return stringToIntArray(input);
    }

    private static int[] stringToIntArray(String input) {
        int[] ret = new int[3];
        for (int i = 0; i < 3; i++) {
            ret[i] = Character.getNumericValue(input.charAt(i));
        }
        return ret;
    }

    private static void validateInput(String input) {
        validateLength(input);
        validateNumbers(input);
        validateDuplicate(input);
    }


    private static void validateLength(String input) {
        if (input.length() != RANDOM_NUMBER_COUNTS) {
            throw new IllegalArgumentException("input should be three numbers with no spaces");
        }
    }

    // check each number 1~9
    private static void validateNumbers(String input) {
        for (int i = 0; i < RANDOM_NUMBER_COUNTS; i++) {
            int ascii = (int) input.charAt(i);
            if (ascii < ASCII_ONE || ascii > ASCII_NINE) {
                throw new IllegalArgumentException("Input should be three integers in range (1~9)");
            }
        }
    }

    private static void validateDuplicate(String input) {
        boolean duplicated = false;
        if (input.charAt(0) == input.charAt(1)) {
            duplicated = true;
        }
        if (input.charAt(1) == input.charAt(2)) {
            duplicated = true;
        }
        if (input.charAt(0) == input.charAt(2)) {
            duplicated = true;
        }

        if (duplicated) {
            throw new IllegalArgumentException("Input numbers should not be duplicated");
        }
    }
}
