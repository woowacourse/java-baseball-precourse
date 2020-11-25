package baseball;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        if (hasZero(playerNumber)) {
            throw new IllegalArgumentException();
        }
        if (isRepeated(playerNumber)) {
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

    public static boolean hasZero(String playerNumber) {
        String zero = "0";
        if (playerNumber.contains(zero)) {
            return true;
        }
        return false;
    }

    public static boolean isRepeated(String playerNumber) {
        int lengthOfPlayerNumber = playerNumber.length();
        String[] playerNumberDigitArr = playerNumber.split("");
        Set<String> playerNumberDigitSet = new HashSet<>();
        for (int i = 0; i < playerNumber.length(); i++) {
            playerNumberDigitSet.add(playerNumberDigitArr[i]);
        }
        if (playerNumberDigitSet.size() != lengthOfPlayerNumber) {
            return true;
        }
        return false;
    }
}
