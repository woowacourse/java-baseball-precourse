package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private static final int DIGIT = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    private List<Integer> numbers;

    public RandomNumbers() {
    }

    public void setNumbers() {
        this.numbers = generateThreeNumbers();
    }

    public int getNumber(int index) {
        return this.numbers.get(index);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getNumberSize() {
        return this.numbers.size();
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
