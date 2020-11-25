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

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        // 3자리 랜덤 숫자 생성
        int[] answer = generateRandomNumbers();

    }
}
