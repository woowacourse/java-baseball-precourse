package baseball;

import java.util.Scanner;

public class UserInputScanner {
    private static final String GUESS_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

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
}
