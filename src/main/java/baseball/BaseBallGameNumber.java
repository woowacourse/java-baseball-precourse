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

    private boolean checkValidInput(String inputNumber) {
        if (!InputCheckUtils.isNumeric(inputNumber)) {
            return false;
        }

        if (inputNumber.length() > NUMBER_OF_DIGITS || inputNumber.length() < NUMBER_OF_DIGITS) {
            return false;
        }

        if (InputCheckUtils.hasDuplicated(inputNumber)) {
            return false;
        }

        return true;
    }
}
