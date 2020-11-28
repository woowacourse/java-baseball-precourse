/*
 * InputValidation.java
 *
 * version 1.1
 *
 * 2020/11/28
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package baseball.domain;

import java.util.Arrays;

public class InputValidation {
    private String checkNumber;

    public InputValidation(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public boolean checkValidNumber() {
        if (!isNumber()) {
            return false;
        }
        if (!isValidLength()) {
            return false;
        }
        if (!isDuplicated()) {
            return false;
        }

        return true;
    }

    private boolean isNumber() {
        String regExp = "^[0-9]+$";
        return checkNumber.matches(regExp);
    }

    private boolean isDuplicated() {
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
