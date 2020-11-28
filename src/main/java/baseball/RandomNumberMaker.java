package baseball;

import java.util.ArrayList;
import java.util.List;

import utils.RandomUtils;

public class RandomNumberMaker {
    private static final int DIGIT = 3;
    private static final int NUMBER_RANGE_START = 1;
    private static final int NUMBER_RANGE_END = 9;

    private List<Integer> randomNumber = new ArrayList<>();

    public List<Integer> makeRandomNumber() {
        int oneDigitRandomNumber = RandomUtils.nextInt(NUMBER_RANGE_START, NUMBER_RANGE_END);
        if (!randomNumber.contains(oneDigitRandomNumber)) {
            randomNumber.add(oneDigitRandomNumber);
        }
        if (randomNumber.size() == DIGIT) {
            return randomNumber;
        }
        return makeRandomNumber();
    }
}
