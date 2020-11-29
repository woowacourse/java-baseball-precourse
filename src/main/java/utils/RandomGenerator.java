package utils;

import java.util.Arrays;

public class RandomGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    public static int[] generateRandomNumbers(int randomLength) {
        int[] randomNumbers = new int[randomLength];
        int digit = 0;

        while (digit < randomLength) {
            int randomNumber = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            if (Arrays.stream(randomNumbers).noneMatch(x -> x == randomNumber)) {
                randomNumbers[digit] = randomNumber;
                digit ++;
            }
        }

        return randomNumbers;
    }
}
