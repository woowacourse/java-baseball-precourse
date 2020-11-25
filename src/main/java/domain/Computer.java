package domain;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.Set;

public class Computer {
    private final int NUMBER_COUNT = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private StringBuilder numbersStringBuilder;
    private Set<Integer> numbersSet;

    public Computer() {
        numbersSet = new HashSet<>();
    }

    public String createComputerNumbers() {
        numbersStringBuilder = new StringBuilder();
        while (numbersSet.size() < NUMBER_COUNT) {
            numbersSet.add(RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER));
        }
        for(Integer number : numbersSet) {
            numbersStringBuilder.append(number);
        }
        numbersSet.clear();
        return numbersStringBuilder.toString();
    }


}
