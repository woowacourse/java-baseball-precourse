package baseball.generator;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public abstract class BallGenerator {
    protected static final List<Integer> ballNumbers = getInstance();

    private static List<Integer> getInstance() {
        return IntStream.rangeClosed(1, 9)
                .boxed()
                .collect(toList());
    }

    abstract int getNumber(int index);
}
