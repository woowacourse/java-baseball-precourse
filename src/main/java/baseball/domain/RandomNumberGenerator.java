/*
 * GenerateRandomNumber.java
 *
 * version 1.0
 *
 * 2020/11/27
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package baseball.domain;

import utils.RandomUtils;

public class RandomNumberGenerator {

    public String getRandomNumber() {
        String randomNumber = "";
        InputValidation inputValidation;

        do {
            randomNumber = Integer.toString(RandomUtils.nextInt(123, 987));
            inputValidation = new InputValidation(randomNumber);
        } while(!inputValidation.checkValidNumber());

        return randomNumber;
    }
}
