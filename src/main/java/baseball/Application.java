package baseball;

import view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        // TODO 구현 진행
        play(scanner);
    }

    public static int inputPlayerNumber(String scanner) {
        try {
            int value = Integer.parseInt(scanner);

            Validator.isValidRangeNumber(value);
            Validator.isContainZero(value);
            Validator.isAnyMatchNumbers(value);

            return value;
        } catch (NumberFormatException e) {
            return inputPlayerNumber(scanner);
        }
    }

    public static void play(Scanner scanner) {
        do {
            Computer computer = new Computer();
            cycleGame(computer, scanner);
        } while (doOneMoreGame(scanner.next()));
    }

    public static void cycleGame(Computer computer, Scanner scanner) {
        OutputView.printInputNumber();
        int playerNumber = inputPlayerNumber(scanner.next());

        if (!computer.getResult(playerNumber)) {
            cycleGame(computer, scanner);
        }
    }

    public static boolean doOneMoreGame(String scanner) {
        try {
            Validator.isNotMenuValue(scanner);

            if (Validator.isEqualRestartValue(scanner)) {
                return true;
            }
        } catch (NumberFormatException e) {
            doOneMoreGame(scanner);
        }

        return false;
    }
}
