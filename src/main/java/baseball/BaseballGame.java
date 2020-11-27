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
        int gameStatus = 0;

        while(gameStatus != 2){

            if(gameStatus == 1){                                    // 게임 재시작일 경우 randomNumber 재생성
                randomNumber = new RandomNumber();
            }else if((gameStatus < 0)||(gameStatus > 2)){
                throw new IllegalArgumentException();
            }

            PlayerNumber playerNumber = new PlayerNumber();
            String inputNumber = playerNumber.getInputNumber();

            if(!CheckUtils.isDigit(inputNumber) || !CheckUtils.isLengthThree(inputNumber)){
                throw new IllegalArgumentException();
            }

            playerNumber.makeArray();

            CompareUtils.compareNumber(randomNumber, playerNumber);

            int strike = CompareUtils.getStrike();
            int ball = CompareUtils.getBall();

            gameStatus = OutputView.showHint(strike, ball);
        }

    }
}
