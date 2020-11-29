package baseball;

import java.util.Scanner;

public class InputChannel {

    private static final int RE_GAME_CODE = 1;

    private InputChannel() {
    }

    public static int askBaseballNumber(Scanner scanner) {
        OutputChannel.printBaseBallNumberQuestion();
        try {
            int inputInt = convertStringToInt(scanner.nextLine().strip());
            Validator.ValidateBaseBallNumber(inputInt);
            return inputInt;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return askBaseballNumber(scanner);
        }
    }

    public static boolean askReGame(Scanner scanner) {
        OutputChannel.printCongratulations();
        OutputChannel.printCongratulations();
        try {
            int inputInt = convertStringToInt(scanner.nextLine().strip());
            Validator.ValidateReGameCode(inputInt);
            return inputInt == RE_GAME_CODE;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return askReGame(scanner);
        }
    }

    private static int convertStringToInt(String string) {
        Validator.ValidateStringToInt(string);
        return Integer.parseInt(string);
    }
}
