package baseball.domain;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.Set;

public class Computer {
    private static final int NUMBERS_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public String createRandomComputerNumbers() {
        Set<Integer> numbersSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (numbersSet.size() < NUMBERS_LENGTH) {
            numbersSet.add(RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER));
        }
        for (Integer number : numbersSet) {
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }
}
