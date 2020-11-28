package utils;

import java.util.Arrays;
import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();
    private static final int COUNT = 3;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 9;

    private static int[] computerNumbers = new int[COUNT];

    private RandomUtils() {

    }

    public static int[] getComputerNumbers() {
        makeRamdomNumbers();
        return computerNumbers;
    }

    private static void makeRamdomNumbers(){
        for (int i = 0; i < COUNT; i++) {
            computerNumbers[i] = nextInt(RANGE_START, RANGE_END);
            i = checkSame(i);
        }
    }
    private static int checkSame(int i){
        for (int j = 0; j < i; j++) {
            if (computerNumbers[i] == computerNumbers[j]) {
                return i-1;
            }
        }
        return i;
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
}
