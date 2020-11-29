package utils;

import java.util.Random;

/**
 * 랜덤 숫자를 생성해 반환하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 11월 25일
 */
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
}
