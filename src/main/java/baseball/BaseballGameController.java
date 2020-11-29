package baseball;

import java.util.Scanner;

import static utils.Constant.*;

public class BaseballGameController {

    private Scanner scanner;
    private Player player;
    private BaseballGame baseballGame;

    public BaseballGameController(Scanner scanner) {
        this.scanner = scanner;
        player = new Player(scanner);
        baseballGame = new BaseballGame();
    }

    public void startGame(){
        do {
            playGame();
        }while (checkReplay());
    }

    private void playGame() {
        player.inputBalls();
    }

    private boolean checkReplay() {
        return false;
    }

}
