package baseball;

import java.util.Scanner;

public class GameManager {
    private final User user;
    private final Computer computer;

    public GameManager(Scanner scanner) {
        this.user = new User(scanner);
        this.computer = new Computer();
    }

    public void start() {
        computer.generateNumber();
        /* TODO
        do {

        } while (AnswerChecker.isAnswer);
        isContinue(user.isContinue);
        */
    }

    public boolean isContinue() {
        return false;
    }
}
