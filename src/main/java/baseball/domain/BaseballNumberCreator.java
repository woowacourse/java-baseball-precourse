package baseball.domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumberCreator {

    private BaseballNumberCreator() {
    }

    public static BaseballNumber createBaseballNumber(List<Integer> baseballNumber) {
        return new BaseballNumber(baseballNumber);
    }

    public static BaseballNumber createBaseballNumber() {
        Set<Integer> numbers = new HashSet<>();
        addUntilThreeDigit(numbers);
        return new BaseballNumber(new ArrayList<>(numbers));
    }

    private static void addUntilThreeDigit(Set<Integer> numbers) {
        while (numbers.size() < BaseballNumber.COUNT_OF_DIGIT) {
            numbers.add(RandomUtils.nextInt(BaseballNumber.MIN_OF_NUMBER, BaseballNumber.MAX_OF_NUMBER));
        }
    }
}
