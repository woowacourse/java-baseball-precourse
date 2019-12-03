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
    private static final List<Integer> numbers = IntStream.range(Number.MIN_DIGIT, Number.MAX_DIGIT + 1)
            .boxed()
            .collect(Collectors.toList());

    public List<Integer> getRandomNumber(int totalPick) {
        Collections.shuffle(numbers);
        return numbers.subList(0, totalPick);
    }
}
