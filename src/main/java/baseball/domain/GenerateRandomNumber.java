package baseball.domain;

import utils.RandomUtils;

public class GenerateRandomNumber {

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
