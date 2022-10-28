package baseball.domain;

import java.util.Arrays;

public class UserInputChecker {
    private final String inputString;
    private final boolean isValid;
    private final int VALID_LENGTH = 3;

    public UserInputChecker(String inputString) {
        this.inputString = inputString;
        isValid = setIsValidString();
    }

    public boolean getIsValid() {
        return isValid;
    }

    private boolean setIsValidString() {

        if (!isValidLength()) {
            return false;
        }

        if (isZero()) {
            return false;
        }

        if (isOutOfNumberRange()) {
            return false;
        }

        if (isDuplicated()) {
            return false;
        }

        return true;
    }

    private boolean isDuplicated() {
        String[] strings = inputString.split("");
        Arrays.sort(strings);

        for (int i = 0; i < VALID_LENGTH - 1; i++) {

            if (strings[i].equals(strings[i + 1])) {
                return true;
            }

        }
        return false;
    }

    private boolean isValidLength() {
        return inputString.length() == VALID_LENGTH;
    }

    private boolean isZero() {
        return inputString.contains("0");
    }

    private boolean isOutOfNumberRange() {
        final int MAX_NUM = 987;
        final int MIN_NUM = 123;
        return Integer.parseInt(inputString) > MAX_NUM || Integer.parseInt(inputString) < MIN_NUM;
    }
}
