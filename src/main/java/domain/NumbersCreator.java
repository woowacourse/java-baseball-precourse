package domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersCreator {
    private static final int MIN_VALUE_OF_NUMBER = 1;
    private static final int MAX_VALUE_OF_NUMBER = 9;
    private static final int COUNT_OF_DIGIT = 3;

    private NumbersCreator() {
    }

    public static List<Integer> getNumbers() {
        Set<Integer> numbers = new HashSet<>();
        addUntilThreeDigit(numbers);
        return new ArrayList<>(numbers);
    }

    private static void addUntilThreeDigit(Set<Integer> numbers) {
        while (numbers.size() < COUNT_OF_DIGIT) {
            numbers.add(RandomUtils.nextInt(MIN_VALUE_OF_NUMBER, MAX_VALUE_OF_NUMBER));
        }
    }
}
