package utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int nextInt(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException();
        }

        if (startInclusive < 0) {
            throw new IllegalArgumentException();
        }

        if (startInclusive == endInclusive) {
            return startInclusive;
        }

        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
    }

    public static String makeGameNumber(){
        String gameNumber = "";
        int countLength = 0;

        while (countLength < 3) {
            int randomNumber = RandomUtils.nextInt(1, 9);

            if (!gameNumber.contains(String.valueOf(randomNumber))) {
                gameNumber += randomNumber;
                countLength++;
            }
        }
        return gameNumber;
    }
}
