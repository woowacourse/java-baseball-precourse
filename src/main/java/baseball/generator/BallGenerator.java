package baseball.generator;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public abstract class BallGenerator {
    public static final int PADDING = 1;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;


    protected static final List<Integer> ballNumbers = getInstance();

    private static List<Integer> getInstance() {
        return IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(toList());
    }

    public abstract int getNumber(int index);
}
