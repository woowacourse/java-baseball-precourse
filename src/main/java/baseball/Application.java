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

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        // 3자리 랜덤 숫자 생성
        int[] answer = generateRandomNumbers();
        // 3자리 숫자 입력 받기
        System.out.println("숫자를 입력해주세요 : ");
        String inputString = scanner.nextLine();
        int[] inputNumbers = parseInputNumbers(inputString);

    }
}
