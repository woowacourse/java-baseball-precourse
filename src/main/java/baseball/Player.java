package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    private final Scanner scanner;

    public Player(Scanner scanner) {
        this.scanner = scanner;
    }

    public int gameContinue() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(Message.INPUT_MISMATCH_WARN_MESSAGE);
        }
    }

    public int valueInsert() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(Message.INPUT_MISMATCH_WARN_MESSAGE);
        }
    }
}
