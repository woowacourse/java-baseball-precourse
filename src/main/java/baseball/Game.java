package baseball;

import java.util.Scanner;

public class Game {
    private int answer;

    public Game() {
        this.answer = AnswerGenerator.generateAnswer();
    }

    public static void playGame(Scanner scanner) {
        playRound(scanner);
    }

    public static void playRound(Scanner scanner) {
        int guess = UserInputScanner.getGuess(scanner);
    }
}
