package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    public int getRandomNumbers(int size, final int startInclusive, final int endInclusive) {
        int numbers = 0;

        for (int i = 0; i < size; i++) {
            numbers *= 10;
            numbers += Randoms.pickNumberInRange(startInclusive, endInclusive);
        }

        return numbers;
    }
}
