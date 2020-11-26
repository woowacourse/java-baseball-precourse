package baseball;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        playGame(scanner);

    }

    public static void playGame(Scanner scanner) {
        int strike = 0;
        int ball = 0;
        String computerNumber = getComputerNumber();
        while (strike != 3) {
            String playerNumber = inputPlayerNumber(scanner);

            int[] strikeAndBall = compareNumberOfPlayerAndComputer(playerNumber, computerNumber);
            strike = strikeAndBall[0];
            ball = strikeAndBall[1];

            System.out.println(playerNumber + " : " + computerNumber);
            System.out.println(getHint(strike, ball));
        }
        askRegame(scanner);
    }

    public static void askRegame(Scanner scanner) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String regameChoice = scanner.nextLine();
        if (regameChoice.equals("1")) {
            playGame(scanner);
            return;
        }
        if (regameChoice.equals("2")) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static String getComputerNumber() {
        int computerNumberInt = RandomUtils.nextInt(100, 999);
        String computerNumber = computerNumberInt + "";
        while (hasZero(computerNumber) || isRepeated(computerNumber)) {
            computerNumber = getComputerNumber();
        }
        return computerNumber;
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

    public static int[] compareNumberOfPlayerAndComputer(String playerNumber, String computerNumber) {
        return getStrikeAndBallCount(playerNumber, computerNumber);
    }

    public static int[] getStrikeAndBallCount(String playerNumber, String computerNumber) {
        int ball = 0;
        int strike = 0;
        String[] playerDigitArr = playerNumber.split("");
        for (int i = 0; i < playerDigitArr.length; i++) {
            int indexOfSameDigitOfComputerNumber = getIndexOfSameDigitOfComputerNumber(playerDigitArr[i], computerNumber);
            strike += getStrikeCount(indexOfSameDigitOfComputerNumber, i);
            ball += getBallCount(indexOfSameDigitOfComputerNumber, i);
        }

        return new int[] {strike, ball};
    }

    public static int getIndexOfSameDigitOfComputerNumber(String playerDigit, String computerNumber) {
        if (computerNumber.contains(playerDigit)) {
            return computerNumber.indexOf(playerDigit);
        }
        return -1;
    }

    public static int getStrikeCount(int indexOfSameDigitOfComputerNumber, int indexOfSameDigitOfPlayerNumber) {
        if (indexOfSameDigitOfComputerNumber == indexOfSameDigitOfPlayerNumber) {
            return 1;
        }
        return 0;
    }

    public static int getBallCount(int indexOfSameDigitOfComputerNumber, int indexOfSameDigitOfPlayerNumber) {
        if (indexOfSameDigitOfComputerNumber != indexOfSameDigitOfPlayerNumber && indexOfSameDigitOfComputerNumber >= 0) {
            return 1;
        }
        return 0;
    }

    public static String getHint(int strike, int ball) {
        StringBuilder hint = new StringBuilder("");
        if (strike == 0 && ball == 0) {
            hint.append("낫싱");
        }
        if (ball != 0) {
            hint.append(ball + "볼 ");
        }
        if (strike != 0) {
            hint.append(strike + "스트라이크");
        }
        return hint.toString();
    }
}
