package baseball.domain;

import baseball.generator.RandomNumberGenerator;

public class Target {
    private String targetNumber = RandomNumberGenerator.getRandomNumber();

    public Target(){
    }

    public String getTargetNumber(){
        return targetNumber;
    }
}
