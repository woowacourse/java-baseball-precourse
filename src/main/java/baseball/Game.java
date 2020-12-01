package baseball;

import java.util.Scanner;

/**
 * 게임이 진행되는 클래스
 */
public class Game {

    private final RandomNumberGenerator randomNumberGenerator;
    private final InputHandler inputHandler;
    private boolean isGoing;

    public Game(Scanner scanner) {
        this.inputHandler = new InputHandler(scanner);
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void start() {
        isGoing = true;
        while (isGoing) {
            play();
        }
    }

    private void play() {
        boolean win = false;
        String random = randomNumberGenerator.makeRandomNumber();

        while (!win) {
            String input = inputHandler.getNumbersInput();
            NumberComparator numberComparator = new NumberComparator(input, random);
            win = numberComparator.correctNumbers();
        }
        isGoing = inputHandler.getRestartInput();
    }
}
