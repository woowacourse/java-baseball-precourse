package baseball;

import view.OutputView;

import java.util.ArrayList;
import java.util.List;
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

            if (value < 100 || value > 999) {
                throw new IllegalArgumentException();
            }

            if (isContainZero(value)) {
                throw new IllegalArgumentException();
            }

            if (isAnyMatchNumbers(value)) {
                throw new IllegalArgumentException();
            }

            return value;
        } catch (NumberFormatException e) {
            return inputPlayerNumber(scanner);
        }
    }

    public static boolean isAnyMatchNumbers(int number) {
        char[] chars = Integer.toString(number).toCharArray();
        List<Character> values = new ArrayList<>();

        for (char c : chars) {
            if (values.contains(c)) {
                return true;
            }

            values.add(c);
        }

        return false;
    }

    public static void play(Scanner scanner) {
        Computer computer = new Computer();

        cycleGame(computer, scanner);
    }

    public static void cycleGame(Computer computer, Scanner scanner) {
        OutputView.printInputNumber();
        int playerNumber = inputPlayerNumber(scanner.next());

        if (!computer.getResult(playerNumber)) {
            cycleGame(computer, scanner);
        }
    }

    public static boolean isContainZero(int value) {
        char[] chars = Integer.toString(value).toCharArray();

        for (char c : chars) {
            if (c == '0') {
                return true;
            }
        }

        return false;
    }
}
