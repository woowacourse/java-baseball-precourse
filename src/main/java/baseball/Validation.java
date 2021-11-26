package baseball;

import constant.SystemMessage;

public class Validation {
    public static int isRightDigit(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(SystemMessage.NO_NUMBER_ERROR);
            }
        }
        return Integer.parseInt(input);
    }

    public static void isValidRange(int value) {
        if (value < SystemMessage.START_INCLUSIVE || value > SystemMessage.END_INCLUSIVE) {
            throw new IllegalArgumentException(SystemMessage.INVALID_RANGE);
        }
    }

    public static void containZero(int value) {
        for (char num : String.valueOf(value).toCharArray()) {
            if (num == SystemMessage.ZERO) {
                throw new IllegalArgumentException(SystemMessage.CONTAIN_ZERO);
            }
        }
    }

    public static void isPermittedInput(int value) {
        if (value != SystemMessage.REPEAT && value != SystemMessage.STOP) {
            throw new IllegalArgumentException(SystemMessage.INVALID_NUMBER);
        }
    }

}
