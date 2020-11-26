package baseball.game;

import java.util.Scanner;

public class BaseBallGame {
    private final GameManager gameManager;

    public BaseBallGame(Scanner scanner) {
        this.gameManager = new GameManager(scanner);
    }

    public void start() {
        do {
            gameManager.start();
        } while (gameManager.isContinue());
    }

}
