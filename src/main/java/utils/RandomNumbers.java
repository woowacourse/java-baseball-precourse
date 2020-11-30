package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class RandomNumbers {
    public static final int START_INDEX = 1;
    public static final int LAST_INDEX = 9;

    private RandomNumbers() {
    }

    public static List<Integer> getInstance(int size) {
        List<Integer> numbers = new ArrayList<>();
        untilCreateNumber(size, numbers);
        return Collections.unmodifiableList(numbers);
    }

    private static void untilCreateNumber(int size, List<Integer> numbers) {
        while (numbers.size() != size) {
            checkDuplicate(numbers, RandomUtils.nextInt(START_INDEX, LAST_INDEX));
        }
    }

    private static void checkDuplicate(List<Integer> numbers, int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
