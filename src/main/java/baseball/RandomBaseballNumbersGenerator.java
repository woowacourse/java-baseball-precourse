package baseball;

import utils.RandomUtils;
import java.util.*;

public class RandomBaseballNumbersGenerator {
    private final static int BASEBALL_NUMBER_LENGTH = 3;
    private final static int BASEBALL_NUMBER_MINIMUM = 1;
    private final static int BASEBALL_NUMBER_MAXIMUM = 9;

    public static List<Integer> generate() {
        Set<Integer> generatedBaseballNumbers = generateNewBaseballs();
        return setToList(generatedBaseballNumbers);
    }

    private static Set<Integer> generateNewBaseballs() {
        Set<Integer> baseballNumbers = new HashSet<>();

        while(baseballNumbers.size() < BASEBALL_NUMBER_LENGTH) {
            int randomNumber = RandomUtils.nextInt(BASEBALL_NUMBER_MINIMUM,
                    BASEBALL_NUMBER_MAXIMUM);

            baseballNumbers.add(randomNumber);
        }

        return baseballNumbers;
    }

    private static List<Integer> setToList(Set<Integer> generatedBaseballNumber) {
        return new ArrayList<>(generatedBaseballNumber);
    }
}
