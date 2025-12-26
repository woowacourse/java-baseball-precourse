package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    private final InputValidator inputValidator;

    public InputHandler() {
        this.inputValidator = new InputValidator();
    }

    public int[] readUserEstimation() {
        String input = Console.readLine();
        inputValidator.validateUserEstimation(input);

        return convertToArray(input);
    }

    private int[] convertToArray(String input) {
        int[] numberArray = new int[input.length()];
        for(int i = 0; i < input.length(); i++) {
            numberArray[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        return numberArray;
    }
}
