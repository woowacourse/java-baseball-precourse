package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String playerNumber = inputPlayerNumber(scanner);

    }

    public static String inputPlayerNumber(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumber = scanner.nextLine();

        if (!isNumberFormat(playerNumber)) {
            throw new IllegalArgumentException();
        }
        if (!isThreeDigitNumber(playerNumber)) {
            throw new IllegalArgumentException();
        }

        return playerNumber;
    }

    public static boolean isNumberFormat(String playerNumber) {
        try {
            Integer.parseInt(playerNumber);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isThreeDigitNumber(String playerNumber) {
        int playerNumberInt = Integer.parseInt(playerNumber);
        if (100 <= playerNumberInt && playerNumberInt < 1000) {
            return true;
        }
        return false;
    }
}
