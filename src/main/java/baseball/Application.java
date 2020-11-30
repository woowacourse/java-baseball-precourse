package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        while (true) {
            startGame(scanner);

            if (endProgram(scanner)) {
                break;
            }
        }
    }

    public static boolean endProgram(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInput = getPlayerInput(scanner, 1, 1, 2);

        if (playerInput.equals("2")) {
            return true;
        }

        return false;
    }

    public static String getPlayerInput(Scanner scanner, int requiredLength, int startInclusive, int endInclusive) {
        String playerInput = scanner.nextLine();
        checkLength(playerInput, requiredLength);
        checkNumberRange(playerInput, startInclusive, endInclusive);

        return playerInput;
    }

    public static void startGame(Scanner scanner) {
        int[] computerNumber = generateRandomNumber();

        while (true) {
            int[] playerNumber = getPlayerNumber(scanner);
            String result = getResult(computerNumber, playerNumber);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static String getResult(int[] computerNumber, int[] playerNumber) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i=0; i<computerNumber.length; i++) {
            if (checkStrike(computerNumber, i, playerNumber)) {
                strikeCount++;
            }
        }

        for (int i=0; i<computerNumber.length; i++) {
            if (checkBall(computerNumber, i, playerNumber)) {
                ballCount ++;
            }
        }

        return makeResultString(ballCount, strikeCount);
    }

    public static String makeResultString(int ballCount, int strikeCount) {
        String result = "";

        if (ballCount == 0 && strikeCount != 0) {
            result = strikeCount + "스트라이크";
        }

        if (ballCount != 0 && strikeCount == 0) {
            result = ballCount + "볼";
        }

        if (ballCount > 0 && strikeCount > 0) {
            result = ballCount + "볼 " + strikeCount + "스트라이크";
        }

        if (ballCount == 0 && strikeCount == 0) {
            result = "낫싱";
        }

        return result;
    }

    public static boolean checkBall(int[] computerNumber, int computerIndex, int[] playerNumber) {
        for (int i=0; i<playerNumber.length; i++) {
            if (i == computerIndex) {
                continue;
            }

            if (computerNumber[computerIndex] == playerNumber[i]) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkStrike(int[] computerNumber, int sameIndex, int[] playerNumber) {
        return computerNumber[sameIndex] == playerNumber[sameIndex];
    }

    public static int[] getPlayerNumber(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = getPlayerInput(scanner, 3, 1, 9);
        int[] playerNumber = new int[3];

        for (int i=0; i<playerInput.length(); i ++) {
            playerNumber[i] = Integer.parseInt(playerInput.substring(i, i + 1));
        }

        if (!allDifferentNumbers(playerNumber)) {
            throw new IllegalArgumentException();
        }

        return playerNumber;
    }

    public static void checkLength(String playerInput, int requiredLength) {
        if (playerInput.length() != requiredLength) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNumberRange(String playerInput, int startInclusive, int endInclusive) {
        char startChar = Integer.toString(startInclusive).charAt(0);
        char endChar = Integer.toString(endInclusive).charAt(0);

        for (int i=0; i<playerInput.length(); i++) {
            char temp = playerInput.charAt(i);

            if (startChar <= temp && temp <= endChar) {
                continue;
            }

            throw new IllegalArgumentException();
            }
    }

    public static int[] generateRandomNumber() {
        int[] computerNumber = new int[3];

        while (true) {
            for (int i=0; i<computerNumber.length; i++) {
                computerNumber[i] = RandomUtils.nextInt(1, 9);
            }

            if (allDifferentNumbers(computerNumber)) {
                break;
            }
        }

        return computerNumber;
    }

    public static boolean allDifferentNumbers(int[] number) {
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
