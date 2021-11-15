package utils;

import java.util.Random;

public class RandomUtils {
	private static final Random RANDOM = new Random(); // static이 붙었으므로 클래스 변수

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
