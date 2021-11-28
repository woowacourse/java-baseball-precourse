package baseball.player;

import baseball.utils.RandomDigitsGenerator;

public class Computer extends Player{

    public void setGameDigits() {
        this.digits = RandomDigitsGenerator.createRandomDigits();
    }
}
