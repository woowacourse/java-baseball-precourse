package baseball.domain;

import utils.RandomUtils;

public class GenerateRandomNumber {

    public String getRandomNumber() {
        String randomNumber = "";
        InputValidation inputValidation = new InputValidation(randomNumber);
        do {
            randomNumber = Integer.toString(RandomUtils.nextInt(123, 987));
        } while(inputValidation.checkValidNumber());
        return randomNumber;
    }
}
