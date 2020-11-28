package baseball;

import java.util.ArrayList;
import java.util.List;

import utils.RandomUtils;

public class RandomNumberMaker {
    private static final int DIGIT = 3;
    private static final int NUMBER_RANGE_START = 1;
    private static final int NUMBER_RANGE_END = 9;

    private static List<Integer> randomNumbers = new ArrayList<>();

    public static List<Integer> makeRandomNumbers() {
        int oneDigitRandomNumber = RandomUtils.nextInt(NUMBER_RANGE_START, NUMBER_RANGE_END);

        if (!randomNumbers.contains(oneDigitRandomNumber)) {
            randomNumbers.add(oneDigitRandomNumber);
        }

        if (randomNumbers.size() == DIGIT) {
            return randomNumbers;
        }

        return makeRandomNumbers();
    }

}
