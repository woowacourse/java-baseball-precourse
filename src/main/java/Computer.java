import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;
    private static final List<Integer> RANGE = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed().collect(Collectors.toList());

    public static int[] createNumbers() {
        Collections.shuffle(RANGE);
        return RANGE.stream()
                .limit(NUMBER_COUNT)
                .mapToInt(i -> i)
                .toArray();
    }
}
