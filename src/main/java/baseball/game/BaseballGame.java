package baseball.game;

import baseball.game.utils.RandomNumberController;

import static baseball.game.constants.BaseballGameConst.RANDOM_NUMBER_COUNTS;

public class BaseballGame {

    private int[] randomNumbers;
    private RandomNumberController randomNumberController;

    public BaseballGame(){
        randomNumberController = new RandomNumberController();
    }

    public void start(){
        //랜덤 숫자 생성
        randomNumbers = randomNumberController.getThreeRandomNumbers();
        for(int i=0;i<3;i++){
            System.out.println(randomNumbers[i]);
        }

    }

}
