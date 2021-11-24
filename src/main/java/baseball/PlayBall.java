package baseball;

import baseball.number.ComputerNumber;

public class PlayBall {
    ComputerNumber computerNumber;

    public void startGame() {
        computerNumber = new ComputerNumber();
        computerNumber.creatComputerNumber();
    }

    private void getUserInput(){

    }
}
