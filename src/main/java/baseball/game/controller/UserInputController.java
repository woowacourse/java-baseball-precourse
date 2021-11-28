package baseball.game.controller;

import camp.nextstep.edu.missionutils.Console;

import static baseball.game.constants.BaseballGameConst.*;

public class UserInputController {

    public UserInputController() {
    }

    public static int getRestartInput() {
        String input = Console.readLine();
        validateLength(input, RESTART_INPUT_LENGTHS);
        validateOneOrTwo(input);
        return Character.getNumericValue(input.charAt(0));
    }

    public static int[] getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);
        return stringToIntArray(input);
    }

    private static void validateOneOrTwo(String input) {
        if ((int) input.charAt(0) != ASCII_ONE && (int) input.charAt(0) != ASCII_TWO) {
            throw new IllegalArgumentException("input should be 1 or 2");
        }
    }

    private static int[] stringToIntArray(String input) {
        int[] ret = new int[RANDOM_NUMBER_LENGTHS];
        for (int i = 0; i < RANDOM_NUMBER_LENGTHS; i++) {
            ret[i] = Character.getNumericValue(input.charAt(i));
        }
        return ret;
    }

    private static void validateInput(String input) {
        validateLength(input, RANDOM_NUMBER_LENGTHS);
        validateNumbers(input);
        validateDuplicate(input);
    }


    private static void validateLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException("input should be " + length + " numbers with no spaces");
        }
    }

    // check each number 1~9
    private static void validateNumbers(String input) {
        for (int i = 0; i < RANDOM_NUMBER_LENGTHS; i++) {
            int ascii = input.charAt(i);
            if (ascii < ASCII_ONE || ascii > ASCII_NINE) {
                throw new IllegalArgumentException("input should be integers in range (1~9)");
            }
        }
    }

    private static void validateDuplicate(String input) {
        boolean duplicated = input.charAt(0) == input.charAt(1);
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
