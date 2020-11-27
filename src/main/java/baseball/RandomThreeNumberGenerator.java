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
        this.numbers = generatedThreeNumbers();
    }

    public List<Integer> get() {
        return this.numbers;
    }

    private List<Integer> generatedThreeNumbers() {
        List<Integer> generated = new ArrayList<>();
        while (true) {
            if (generated.size() >= 3) {
                break;
            }

            int generatedRandomly = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            if (!generated.contains(generatedRandomly)) {
                generated.add(generatedRandomly);
            }
        }
        return generated;
    }
}
