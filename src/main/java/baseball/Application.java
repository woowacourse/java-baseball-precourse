package baseball;

import baseball.io.InputHandler;
import baseball.io.OutputHandler;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager(
            new Computer(),
            new InputHandler(),
            new OutputHandler()
        );

        gameManager.start();
    }
}
