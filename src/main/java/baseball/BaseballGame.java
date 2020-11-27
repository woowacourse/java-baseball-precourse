package baseball;

import number.PlayerNumber;
import number.RandomNumber;
import utils.CheckUtils;

public class BaseballGame {

    BaseballGame(){

    }

    public static void play(){
        RandomNumber randomNumber = new RandomNumber();

        PlayerNumber playerNumber = new PlayerNumber();
        String inputNumber = playerNumber.getInputNumber();

        if(!CheckUtils.isDigit(inputNumber) || !CheckUtils.isLengthThree(inputNumber)){
            throw new IllegalArgumentException();
        }

    }
}
