package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    private final InputValidator inputValidator;

    public InputHandler() {
        this.inputValidator = new InputValidator();
    }

    public String readUserEstimation() {
        String input = Console.readLine();
        inputValidator.validateUserEstimation(input);

        return input;
    }
}
