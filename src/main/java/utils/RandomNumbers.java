package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class RandomNumbers {
    private RandomNumbers() {
    }

    public static List<Integer> valueOf(int size) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != size) {
            int number = RandomUtils.nextInt(0, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return Collections.unmodifiableList(numbers);
    }
}
