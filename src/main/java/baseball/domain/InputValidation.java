package baseball.domain;

import java.util.Arrays;

public class InputValidation {
    private String checkNumber;

    public InputValidation(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public boolean checkValidNumber() {
        if (!isValidLength()) {
            return false;
        }
        if (!isDuplication()) {
            return false;
        }
        if (!isNumber()) {
            return false;
        }
        return true;
    }

    private boolean isNumber() {
        return Character.isDigit(Integer.valueOf(checkNumber));
    }

    private boolean isDuplication() {
        String[] checkStrings = checkNumber.split("");
        Arrays.sort(checkStrings);
        for (int i = 0; i < checkStrings.length - 1; i++) {
            if (checkStrings[i].equals(checkStrings[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidLength() {
        final int NUMBER_LENGTH = 3;
        return checkNumber.length() == NUMBER_LENGTH;
    }
}
