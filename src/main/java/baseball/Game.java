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
        this.hint = new Hint();
        this.running = true;
        this.scanner = scanner;
    }

    public void start() {
        do {
            computer.generateAnswer();
            startGame();
        } while (isRestart());
    }

    private void startGame() {
        while (running) {
            user.enterNumber(scanner);
            hint.countHint(computer.getAnswer(), user.getUserNumber());
            hint.printHint();

            if (hint.getStrike() == Constant.VICTORY_CONDITION) {
                System.out.println(Constant.VICTORY_MESSAGE);
                running = false;
            }
        }
    }

    private boolean isRestart() {
        System.out.println(Constant.RESTART_MESSAGE);

        int restart = scanner.nextInt();

        if (restart == Constant.RESTART) {
            this.running = true;
            return true;
        } else if (restart == Constant.EXIT) {
            return false;
        } else {
            throw new IllegalArgumentException(Constant.WRONG_INPUT);
        }
    }
}
