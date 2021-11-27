package baseball.player;

import baseball.utils.RandomDigitsGenerator;

public class Computer extends Player{

    public Computer() {
        super(RandomDigitsGenerator.createRandomDigits());
    }
}
