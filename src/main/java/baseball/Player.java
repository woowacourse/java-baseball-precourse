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
        return guess;
    }

    public char inputProgress() {
        return progress.charAt(0);
    }
}