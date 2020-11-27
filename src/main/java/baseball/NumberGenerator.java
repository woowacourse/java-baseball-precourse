package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.RandomUtils;

public class NumberGenerator {
    private final static int GENERATE_COUNT = 3;
    private final static int START_NUMBER = 1;
    private final static int END_NUMBER = 9;

    private Set<Integer> numbers;

    public NumberGenerator() {
        this.numbers = new HashSet<>();
    }

    public List<Integer> generateNumber() {
        while (numbers.size() != GENERATE_COUNT) {
            numbers.add(RandomUtils.nextInt(START_NUMBER, END_NUMBER));
        }
        return new ArrayList<Integer>(numbers);
    }

}
