package baseball;

import java.util.Scanner;

public class BaseballGameController {

    private Scanner scanner;
    private BaseballGame baseballGame;

    public BaseballGameController(Scanner scanner) {
        this.scanner = scanner;
        baseballGame = new BaseballGame(scanner);
    }

    public void startGame(){
        do {
            playGame();
        }while (checkReplay());
    }

    private void playGame() {
        baseballGame.initialBalls();
        baseballGame.compareBalls();
    }

    private boolean checkReplay() {
        return false;
    }

}
