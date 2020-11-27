package baseball;

import number.Constant;
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
        int gameStatus = Constant.START;

        while(gameStatus != Constant.END_GAME){

            if(gameStatus == Constant.RESTART){                                    // 게임 재시작일 경우 randomNumber 재생성
                randomNumber = new RandomNumber();
            }else if((gameStatus < Constant.START)||(gameStatus > Constant.END_GAME)){
                throw new IllegalArgumentException();
            }

            PlayerNumber playerNumber = new PlayerNumber();
            String inputNumber = playerNumber.getInputNumber();

            CheckUtils.isAppropriate(inputNumber);

            playerNumber.makeArray();

            CompareUtils.compareNumber(randomNumber, playerNumber);

            int strike = CompareUtils.getStrike();
            int ball = CompareUtils.getBall();

            gameStatus = OutputView.showHint(strike, ball);
        }

    }
}
