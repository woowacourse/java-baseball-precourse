package baseball;

import java.util.Scanner;

public class Game {
    private static int answer;

    public Game() {
        this.answer = AnswerGenerator.generateAnswer();
    }

    public static void playGame(Scanner scanner) {
        playRound(scanner);
    }

    public static void playRound(Scanner scanner) {
        boolean ongoing = true;
        do {
            int guess = UserInputScanner.getGuess(scanner);
            boolean correct = roundResult(answer, guess);
        } while (ongoing);
    }

    public static boolean roundResult(int answer, int guess) {
        int[] hint = HintGenerator.getHint(answer, guess);
        int ball = hint[0];
        int strike = hint[1];
        HintPrinter.printHint(ball, strike);
        if (strike == 3) {
            return true;
        }
        return false;
    }
}
