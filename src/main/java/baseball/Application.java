package baseball;

import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int playerValue = 0;

        // TODO 구현 진행
        OutputView.printInputNumber();
        playerValue = inputPlayerNumber(scanner.next());
    }

    public static int inputPlayerNumber(String scanner) {
        try {
            int value = Integer.parseInt(scanner);

            if (value < 100 || value > 999) {
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
}
