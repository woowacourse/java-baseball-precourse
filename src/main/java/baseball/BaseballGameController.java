package baseball;

import utils.OutputView;

import java.util.Scanner;

public class BaseballGameController {

    private Scanner scanner;
    private BaseballGame baseballGame;

    public BaseballGameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame(){
        do {
            playGame();
        }while (checkReplay());
    }

    private void playGame() {
        baseballGame = new BaseballGame(scanner);
        while (!baseballGame.isGameEnd()) {
            baseballGame.inputPlayerBalls();
            baseballGame.getHint();
        }
    }

    private boolean checkReplay() {
        
    }

}
