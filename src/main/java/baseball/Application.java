package baseball;

import java.util.Arrays;
import java.util.Scanner;

import utils.RandomUtils;

public class Application {

    private static final int NUMBERS_LENGTH = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    private static int[] generateRandomNumbers() {
        int[] randomNumbers = new int[NUMBERS_LENGTH];
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            randomNumbers[i] = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
        }
        return randomNumbers;
    }

    private static int[] parseInputNumbers(String inputString) {
        int[] inputNumbers = new int[NUMBERS_LENGTH];
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            inputNumbers[i] = inputString.charAt(i) - '0';
        }
        return inputNumbers;
    }

    private static boolean isInputAcceptable(String inputString) {

        try {
            Integer.parseInt(inputString);
            if (inputString.length() != NUMBERS_LENGTH) {
                throw new IllegalArgumentException();
            }
            if (inputString.contains("0")) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("비정상적인 입력입니다.");
            return false;
        }
    }

    private static int[] countStrikesAndBalls(int[] answer, int[] inputNumbers) {
        int strikes = 0;
        int balls = 0;
        int[] result = new int[2];
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            int num = inputNumbers[i];
            if (answer[i] == inputNumbers[i]) {
                strikes ++;
            } else if (Arrays.stream(answer).anyMatch(x -> x == num)) {
                balls ++;
            }
        }
        result[0] = strikes;
        result[1] = balls;

        return result;
    }

    private static boolean isNothing(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        boolean gameStart = true;

        // start game
        while (gameStart) {

            int[] answer = generateRandomNumbers();
            int[] inputNumbers = null;
            String inputString = "";
            int strikes = -1;
            int balls = -1;
            boolean nothing = false;

            do {
                System.out.println("숫자를 입력해주세요 : ");
                inputString = scanner.nextLine();
            } while (!isInputAcceptable(inputString));

            inputNumbers = parseInputNumbers(inputString);
            int[] numberOfStrikesAndBalls = countStrikesAndBalls(answer, inputNumbers);
            strikes = numberOfStrikesAndBalls[0];
            balls = numberOfStrikesAndBalls[1];
            nothing = isNothing(strikes, balls);

        } // end of game

    }
}
