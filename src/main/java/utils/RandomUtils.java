package utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int nextInt(final int startInclusive, final int endInclusive) {
        try {
            if (startInclusive > endInclusive) {
                throw new IllegalArgumentException();
            }

            if (startInclusive < 0) {
                throw new IllegalArgumentException();
            }

            if (startInclusive == endInclusive) {
                return startInclusive;
            }
        }catch(IllegalArgumentException e){
            System.err.println("입력 값 오류");
            return -1;
        }

        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive) + 1;
    }
}
