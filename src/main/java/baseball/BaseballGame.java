package baseball;

import number.PlayerNumber;
import number.RandomNumber;
import utils.CheckUtils;
import utils.CompareUtils;
import view.OutputView;

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

        playerNumber.makeArray();

        CompareUtils.compareNumber(randomNumber, playerNumber);

        int strike = CompareUtils.getStrike();
        int ball = CompareUtils.getBall();



    }
}
