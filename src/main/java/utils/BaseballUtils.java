package utils;

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
}
