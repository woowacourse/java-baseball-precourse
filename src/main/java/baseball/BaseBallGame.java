package baseball;

import java.util.Scanner;

public class BaseBallGame {

    private final User user;
    private final NumberChecker numberChecker;

    BaseBallGame(Scanner scanner) {
        this.numberChecker = new NumberChecker();
        this.user = new User(scanner, numberChecker);
    }

    void start() {
        while (true) {
            user.getUserInput();
        }
    }

}
