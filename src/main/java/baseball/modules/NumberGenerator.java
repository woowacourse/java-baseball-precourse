package baseball.modules;

import java.util.ArrayList;
import utils.RandomUtils;

/**
 * Generate number for use in game.
 * 
 * @author Kim Hanseul
 */
public class NumberGenerator {
    private static final int NUMBER_RANGE_MIN = 1;
    private static final int NUMBER_RANGE_MAX = 9;

    private ArrayList<Integer> numberRange;
    private int[] generatedNumber;

    private int numberSize;

    public NumberGenerator(final int numberSize) {
        if (numberSize <= 0) {
            throw new IllegalArgumentException();
        }

        if (numberSize > NUMBER_RANGE_MAX - NUMBER_RANGE_MIN + 1) {
            throw new IllegalArgumentException();
        }

        this.numberSize = numberSize;
    }

    /** Return a generated number. */
    public int[] getNumber() {
        return generatedNumber.clone();
    }

    /** Generate a (numberSize)-digit random number with no duplication numbers in each digit. */
    public void generate() {
        initializeNumberRange();
        generatedNumber = new int[numberSize];
        for (int i = 0; i < generatedNumber.length; i++) {
            generatedNumber[i] = popFromNumberRange();
        }
    }
    
    private void initializeNumberRange() {
        numberRange = new ArrayList<Integer>();

        for (int i = NUMBER_RANGE_MIN; i <= NUMBER_RANGE_MAX; i++) {
            numberRange.add(i);
        }
    }

    private int popFromNumberRange() {
        int index = getRandomIndexOfNumberRange();
        int popValue = numberRange.get(index);
        numberRange.remove(index);
        return popValue;
    }

    private int getRandomIndexOfNumberRange() {
        return RandomUtils.nextInt(0, numberRange.size() - 1);
    }
}