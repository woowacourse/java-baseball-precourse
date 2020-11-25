package baseball;

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

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        boolean gameStart = true;
        while (gameStart) {

            int[] answer = generateRandomNumbers();
            int[] inputNumbers = null;
            String inputString = "";

            do {
                System.out.println("숫자를 입력해주세요 : ");
                inputString = scanner.nextLine();
            } while (!isInputAcceptable(inputString));
            inputNumbers = parseInputNumbers(inputString);
            
        }

    }
}
