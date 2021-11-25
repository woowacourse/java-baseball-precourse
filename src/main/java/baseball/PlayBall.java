package baseball;

import baseball.number.ComputerNumber;
import baseball.number.NumberService;

public class PlayBall {
    ComputerNumber computerNumber;
    NumberService numberService;

    public void startGame() {
        computerNumber = new ComputerNumber();
        numberService = new NumberService();

        createComputerNumber();
    }

    private void createComputerNumber(){
        numberService.createComputerNumber(computerNumber);
        getUserInput();
    }

    private void getUserInput(){

    }
}
