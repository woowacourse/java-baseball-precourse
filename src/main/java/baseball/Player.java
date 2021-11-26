package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.SystemMessage;

public class Player {
    public int predictNumber() {
        System.out.printf("%s", SystemMessage.ENTER_NUMBER_MESSAGE);
        String userInput = Console.readLine();
        isValidNumber(userInput);
        return decodeUserInput(userInput);
    }

    public boolean decideGoOrStop() {
        System.out.println(SystemMessage.ENTER_NEXT_GAME_MESSAGE);
        String userInput = Console.readLine();
        isValidInput(userInput);
        if (decodeUserInput(userInput) == SystemMessage.REPEAT) {
            return true;
        }
        return false;
    }

    private void isValidNumber(String input) {
        int value = Validation.isRightDigit(input);
        Validation.isValidRange(value);
        Validation.containZero(value);
    }

    private void isValidInput(String input) {
        int value = Validation.isRightDigit(input);
        Validation.isPermittedInput(value);
    }

    private int decodeUserInput(String userInput) {
        return Integer.parseInt(userInput);
    }

}
