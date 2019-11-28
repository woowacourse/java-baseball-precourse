package baseballgame;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-11-28
 */
public class RandomNumberGenerator {
    private final List<Integer> numbers;

    public RandomNumberGenerator(int startInclusive, int endExclusive) {
        numbers = IntStream.range(startInclusive, endExclusive).boxed().collect(Collectors.toList());
    }

    public List<Integer> getRandomNumber(int totalPick) {
        Collections.shuffle(numbers);
        return numbers.subList(0, totalPick);
    }
}
