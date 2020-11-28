package baseball;

import utils.InputCheckUtils;

import static baseball.Config.NUMBER_OF_DIGITS;

public class BaseBallGameNumber {
    private final String number;

    public BaseBallGameNumber(String number) {
        if (!checkValidInput(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }


    public String getNumber() {
        return number;
    }

    private boolean checkValidInput(String number) {
        if (!InputCheckUtils.isNumeric(number)) {
            return false;
        }

        if (number.length() > NUMBER_OF_DIGITS || number.length() < NUMBER_OF_DIGITS) {
            return false;
        }

        if (InputCheckUtils.hasDuplicated(number)) {
            return false;
        }

        return true;
    }
}
