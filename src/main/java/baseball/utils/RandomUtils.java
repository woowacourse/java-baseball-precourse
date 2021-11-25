package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    public RandomUtils() {
    }

    public static int[] getRandomNumbers(int size, int startInclusive, int endInclusive) {
        int[] numbers = new int[3];

        for (int i = 0; i < size; i++) {
            numbers[i] = Randoms.pickNumberInRange(startInclusive, endInclusive);
        }

        return numbers;
    }
}
