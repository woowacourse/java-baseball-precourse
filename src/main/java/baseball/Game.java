package baseball;

import java.util.Scanner;

public class Game {
    private static int answer;

    public Game() {
        this.answer = AnswerGenerator.generateAnswer();
    }

    public boolean playGame(Scanner scanner) {
        boolean correct;
        do {
            correct = playRound(scanner);
        } while(!correct);
        return GameResetter.getRestartFactor(scanner);
    }

    public boolean playRound(Scanner scanner) {
        int guess = UserInputScanner.getGuess(scanner);
        return roundResult(answer, guess);
    }

    public boolean roundResult(int answer, int guess) {
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
