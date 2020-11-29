package baseball;

import java.util.Scanner;

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

    }
}
