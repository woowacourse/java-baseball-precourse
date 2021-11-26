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

    private void isValidNumber(String input) {
        int value = getNumber(input);
        isValidRange(value);
        containZero(value);
    }

    private int getNumber(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(SystemMessage.NO_NUMBER_ERROR);
            }
        }
        return Integer.parseInt(input);
    }

    private void isValidRange(int value) {
        if (value < SystemMessage.START_INCLUSIVE || value > SystemMessage.END_INCLUSIVE) {
            throw new IllegalArgumentException(SystemMessage.INVALID_RANGE);
        }
    }

    private void containZero(int value) {
        for (char num : String.valueOf(value).toCharArray()) {
            if (num == SystemMessage.ZERO) {
                throw new IllegalArgumentException(SystemMessage.CONTAIN_ZERO);
            }
        }
    }

    private int decodeUserInput(String userInput) {
        return Integer.parseInt(userInput);
    }

}
