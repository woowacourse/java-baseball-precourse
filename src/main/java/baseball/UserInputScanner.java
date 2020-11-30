package baseball;

import java.util.Scanner;

public class UserInputScanner {
    private static final String GUESS_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GUESS_ERROR_MESSAGE = "중복되지 않는 1~9까지로 이루어진 세 자리 수를 입력해주세요.";

    private UserInputScanner() {
    }

    public static String scanUserInput(Scanner scanner) {
        return scanner.nextLine();
    }

    public static void printGuessInputMessage() {
        System.out.print(GUESS_INPUT_MESSAGE);
    }

    public static String scanGuess(Scanner scanner) {
        printGuessInputMessage();
        return scanUserInput(scanner);
    }

    public static int getGuess(Scanner scanner) {
        String guessCandidate = scanGuess(scanner);
        boolean suitability = GuessConditionChecker.checkGuessCondition(guessCandidate);
        if (!suitability) {
            throw new IllegalArgumentException(GUESS_ERROR_MESSAGE);
        }
        return Integer.parseInt(guessCandidate);
    }
}
