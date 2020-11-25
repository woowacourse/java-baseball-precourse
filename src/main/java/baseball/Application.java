package baseball;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String playerNumber = inputPlayerNumber(scanner);
        String computerNumber = getComputerNumber();

    }

    public static String inputPlayerNumber(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumber = scanner.nextLine();
        checkCorrectCondition(playerNumber);

        return playerNumber;
    }

    public static void checkCorrectCondition(String number) {
        if (!isNumberFormat(number)) {
            throw new IllegalArgumentException();
        }
        if (!isThreeDigitNumber(number)) {
            throw new IllegalArgumentException();
        }
        if (hasZero(number)) {
            throw new IllegalArgumentException();
        }
        if (isRepeated(number)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isThreeDigitNumber(String number) {
        int playerNumberInt = Integer.parseInt(number);
        if (100 <= playerNumberInt && playerNumberInt < 1000) {
            return true;
        }
        return false;
    }

    public static boolean hasZero(String number) {
        String zero = "0";
        if (number.contains(zero)) {
            return true;
        }
        return false;
    }

    public static boolean isRepeated(String number) {
        int lengthOfPlayerNumber = number.length();
        String[] playerNumberDigitArr = number.split("");
        Set<String> playerNumberDigitSet = new HashSet<>();
        for (int i = 0; i < number.length(); i++) {
            playerNumberDigitSet.add(playerNumberDigitArr[i]);
        }
        if (playerNumberDigitSet.size() != lengthOfPlayerNumber) {
            return true;
        }
        return false;
    }

    public static String getComputerNumber() {
        int computerNumberInt = RandomUtils.nextInt(100, 999);
        String computerNumber = computerNumberInt + "";
        while (hasZero(computerNumber) || isRepeated(computerNumber)) {
            computerNumber = getComputerNumber();
        }
        return computerNumber;
    }
}
