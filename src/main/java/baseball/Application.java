package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        int[] computerNumber = generateRandomNumber();
        int[] playerNumber = getPlayerNumber(scanner);
    }

    public static int[] getPlayerNumber(Scanner scanner) {
        int[] playerNumber = new int[3];
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = scanner.nextLine();

        // 3자리 입력인지 체크
        checkLength(playerInput, 3);

        // 각 자리수가 1에서 9사이의 숫자인지 체크
        checkIfNumberFromAToB(playerInput, 1, 9);

        // 숫자 배열화 기능
        for (int i=0; i<playerInput.length(); i ++) {
            playerNumber[i] = Integer.parseInt(playerInput.substring(i, i + 1));
        }

        // 서로 다른 숫자인지 체크
        if (!checkAllDifferent(playerNumber)) {
            throw new IllegalArgumentException();
        }

        return playerNumber;
    }

    public static void checkLength(String playerInput, int requiredLength) {
        if (playerInput.length() != requiredLength) {
            throw new IllegalArgumentException();
        }
    }

    // 각 자리수가 A에서 B사이의 숫자인지 체크하는 기능
    public static void checkIfNumberFromAToB(String playerInput, int fromA, int toB) {
        char fromAChar = Integer.toString(fromA).charAt(0);
        char toBChar = Integer.toString(toB).charAt(0);

        for (int i=0; i<playerInput.length(); i++) {
            char temp = playerInput.charAt(i);

            if (fromAChar <= temp && temp <= toBChar) {
                continue;
            }

            throw new IllegalArgumentException();
            }
    }

    // 컴퓨터의 랜덤 숫자 생성 기능
    public static int[] generateRandomNumber() {
        int[] computerNumber = new int[3];

        while (true) {

            // 숫자 배열화 기능
            for (int i=0; i<computerNumber.length; i++) {
                computerNumber[i] = RandomUtils.nextInt(1, 9);
            }

            // 서로 다른 숫자인지 체크
            if (checkAllDifferent(computerNumber)) {
                break;
            }
        }

        return computerNumber;
    }

    // 서로 다른 숫자인지 체크하는 기능
    public static boolean checkAllDifferent(int[] number) {
        if (number[0] == number[1]) {
            return false;
        }

        if (number[1] == number[2]) {
            return false;
        }

        if (number[2] == number[0]) {
            return false;
        }

        return true;
    }
}
