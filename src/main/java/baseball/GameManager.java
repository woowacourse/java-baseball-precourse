package baseball;

import java.util.Scanner;

public class GameManager {

    private final InputHandler inputHandler;
    private final BaseBallNumber baseBallNumber;

    public GameManager(Scanner scanner) {
        inputHandler = new InputHandler(scanner);
        baseBallNumber = new BaseBallNumber();
    }

    public void gameStart() {}

}
