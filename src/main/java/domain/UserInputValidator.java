/*
 * UserInputValidator.java
 * java-baseball-precourse
 *
 * Version 0.1
 *
 * Created by 김경준 on 28/11/2019.
 *
 * Copyright © 2019 kouz95. All rights reserved.
 */

package domain;

public class UserInputValidator {
    private final String inputString;
    private final boolean isValid;

    public UserInputValidator(String inputString) {
        this.inputString = inputString;
        isValid = setIsValidString();
    }

    private boolean setIsValidString() {
        return isValidLength();
    }

    private boolean isValidLength() {
        final int VALID_LENGTH = 3;
        return inputString.length() == VALID_LENGTH;
    }
}
