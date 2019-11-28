/*
 * UserInputValidator.java
 * java-baseball-precourse
 *
 * Version 0.4
 *
 * Created by 김경준 on 28/11/2019.
 *
 * Copyright © 2019 kouz95. All rights reserved.
 */

package domain;

import utils.StringHandler;

public class UserInputValidator {
    private final String inputString;
    private final boolean isValid;

    public UserInputValidator(String inputString) {
        this.inputString = inputString;
        isValid = setIsValidString();
    }

    private boolean setIsValidString() {
        if(!isValidLength()) {
            return false;
        }
        if(isOutOfNumberRange()) {
            return false;
        }
        if(StringHandler.isDuplicated(inputString)) {
            return false;
        }
        return true;
    }

    private boolean isValidLength() {
        final int VALID_LENGTH = 3;
        return inputString.length() == VALID_LENGTH;
    }

    private boolean isOutOfNumberRange() {
        final int MAX_NUM = 987;
        final int MIN_NUM = 123;
        return Integer.parseInt(inputString) > MAX_NUM || Integer.parseInt(inputString) < MIN_NUM;
    }
}
