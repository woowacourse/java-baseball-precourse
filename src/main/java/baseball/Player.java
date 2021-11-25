package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.SystemMessage;

public class Player {
    public int predictNumber() {
        System.out.printf("%s", SystemMessage.ENTER_NUMBER_MESSAGE);
        return isValidNumber(Console.readLine());
    }

    private int isValidNumber(String input) {
        int value = getNumber(input);
        isValidRange(value);
        containZero(value);
        return Integer.parseInt(input);
    }

    private int getNumber(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) throw new IllegalArgumentException(SystemMessage.NO_NUMBER_ERROR);
        }
        return Integer.parseInt(input);
    }

    private void isValidRange(int value) {
        if (value < 100 || value > 999) throw new IllegalArgumentException(SystemMessage.INVALID_RANGE);
    }

    private void containZero(int value) {
        for (char num : String.valueOf(value).toCharArray()) {
            if (num == '0') throw new IllegalArgumentException(SystemMessage.CONTAIN_ZERO);
        }
    }

}
