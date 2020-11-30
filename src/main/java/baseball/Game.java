package baseball;

import java.util.Scanner;

public class Game {
    private Computer computer;
    private User user;
    private Hint hint;
    private boolean running;
    private Scanner scanner;

    public Game(Scanner scanner) {
        this.computer = new Computer();
        this.user = new User();
        this.hint = new Hint(0, 0);
        this.running = true;
        this.scanner = scanner;
    }

    public void start() {
        do {
            startGame();
        } while (isRestart());
    }

    private void startGame() {

    }

    private boolean isRestart() {
        return true;
    }
}
