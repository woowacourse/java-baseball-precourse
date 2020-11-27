package baseball;

import java.util.Scanner;

import static utils.TextResource.STATEMENT_ASK_RESTART;
import static utils.TextResource.STATEMENT_NUMBER_INPUT;

public class Player {
    private Scanner scanner = null;

    public Player(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputNumber() {
        scanner.reset();
        System.out.print(STATEMENT_NUMBER_INPUT);
        System.out.print("");
        String inputNumber = scanner.next();
        return inputNumber;
    }

    public boolean askRestart() {
        scanner.reset();
        System.out.println(STATEMENT_ASK_RESTART);
        int restart = scanner.nextInt();
        if (restart == 1) {
            return true;
        }
        return false;
    }
}
