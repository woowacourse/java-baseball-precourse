package utils;

import java.util.Scanner;

public class BaseballUtils {

    static final int NUMBER_COUNT = 3;
    static final int MIN_NUMBER = 0;
    static final int MAX_NUMBER = 9;

    public static int[] generateRandomNumbers() {
        int[] randomNumbers = new int[NUMBER_COUNT];
        boolean[] checkNumbers = new boolean[MAX_NUMBER + 1];

        int count = 0;
        while (count < NUMBER_COUNT) {
            int random = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
            if (checkNumbers[random]) {
                continue;
            }

            randomNumbers[count] = random;
            checkNumbers[count++] = true;
        }

        return randomNumbers;
    }

    public static int[] getPlayerNumbers(final Scanner sc) {
        System.out.print("숫자를 입력해주세요 : ");
        int playerInput = getIntInput(sc);

        return getValidNumbers(playerInput);
    }

    public static int getIntInput(final Scanner sc) {
        if (!sc.hasNextInt()) {
            System.out.println("int 입력이 아닌 오류 발생");
            throw new IllegalArgumentException();
        }

        return sc.nextInt();
    }

    public static int[] getValidNumbers(int playerInput) {
        int[] playerNumbers = new int[NUMBER_COUNT];
        boolean[] checkDuplicated = new boolean[MAX_NUMBER + 1];

        if (playerInput / 100 == 0 || playerInput / 1000 == 1) {
            System.out.println("숫자 갯수 오류 발생");
            throw new IllegalArgumentException();
        }

        for (int i = NUMBER_COUNT-1; i > 0; i--) {
            int divison = (int)Math.pow(10, i);
            int number = playerInput / divison;
            playerInput = playerInput % divison;

            playerNumbers[NUMBER_COUNT - i -1] = number;
        }
        playerNumbers[NUMBER_COUNT-1] = playerInput;

        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (playerNumbers[i] <= MIN_NUMBER || playerNumbers[i] > MAX_NUMBER) {
                System.out.println("범위 오류 발생");
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (checkDuplicated[playerNumbers[i]]) {
                System.out.println("중복 에러 발생");
                throw new IllegalArgumentException();
            }

            checkDuplicated[playerNumbers[i]] = true;
        }

        return playerNumbers;
    }
}
