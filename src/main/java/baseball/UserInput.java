package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private int[] input;

    public UserInput() {
        this.input = new int[Constant.NUMBER_OF_NUMBERS];
    }

    public void setInput() {
        System.out.print(Constant.PLEASE_INPUT_NUMBER);

        String input = Console.readLine();
        Validation.isValidInput(input);

        for (int i = 0; i < Constant.NUMBER_OF_NUMBERS; i++) {
            this.input[i] = input.charAt(i) - '0';

        }
    }

    public int[] getInput() {
        return this.input;
    }

}
