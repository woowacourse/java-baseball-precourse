package baseball;

import java.util.Scanner;

/**
 * 게임이 진행되는 클래스
 */
public class PlayGame {

    private final CheckRandomNumber checkRandomNumber;
    private final InputHandler inputHandler;
    private boolean goStop;

    public PlayGame(Scanner scanner) {
        this.inputHandler = new InputHandler(scanner);
        this.checkRandomNumber = new CheckRandomNumber();
    }

    public void start() {
        goStop = true;
        while (goStop) {
            play();
        }
    }

    private void play() {
        boolean win = false;
        String random = checkRandomNumber.makeRandomNumber();

        while (!win) {
            String input = inputHandler.inputValue();
            CheckResult checkResult = new CheckResult(input, random);
            win = checkResult.correctNumbers();
        }
        goStop = inputHandler.restartValue();
    }
}
