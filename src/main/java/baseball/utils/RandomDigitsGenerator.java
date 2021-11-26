package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomDigitsGenerator {

    public static final int RANDOM_DIGIT_MIN = 1;
    public static final int RANDOM_DIGIT_MAX = 9;
    public static final int RANDOM_DIGIT_COUNT = 3;

    private RandomDigitsGenerator() {}

    public static List<Integer> createRandomDigits() {
        List<Integer> randomDigits = new ArrayList<>();

        while (randomDigits.size() < RANDOM_DIGIT_COUNT) {
            int randomDigit = createRandomDigit();

            if(!randomDigits.contains(randomDigit)) {
                randomDigits.add(randomDigit);
            }
        }
        return randomDigits;
    }

    public static int createRandomDigit() {
        return Randoms.pickNumberInRange(RANDOM_DIGIT_MIN, RANDOM_DIGIT_MAX);
    }
}
