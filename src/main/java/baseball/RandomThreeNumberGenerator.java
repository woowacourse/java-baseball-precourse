package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class RandomThreeNumberGenerator {
    private static final int DIGIT = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    private List<Integer> numbers;

    public RandomThreeNumberGenerator() {
        this.numbers = generateThreeNumbers();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private List<Integer> generateThreeNumbers() {
        List<Integer> generated = new ArrayList<>();
        while (true) {
            if (overflow(generated)) {
                break;
            }
            addNotDuplicated(generated);
        }
        return generated;
    }

    private boolean overflow(List<Integer> list) {
        if (list.size() >= DIGIT) {
            return true;
        }
        return false;
    }

    private void addNotDuplicated(List<Integer> list) {
        int generated = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
        if (!list.contains(generated)) {
            list.add(generated);
        }
    }
}
