package baseball;

import java.util.Scanner;
import utils.VerificationUtils;

public class Player {
    private Scanner scanner;
    private String guess;
    private String progress;

    public Player(Scanner scanner) {
        this.scanner = scanner;
        guess = "";
        progress = "";
    }

    public String inputGuess() {
        guess = scanner.nextLine();
        VerificationUtils.verifyGuess(guess);
        return guess;
    }

    public char inputProgress() {
        progress = scanner.nextLine();
        VerificationUtils.verifyProgress(progress);
        return progress.charAt(0);
    }
}