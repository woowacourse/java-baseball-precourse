package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import utils.RandomUtils;

public class NumberGenerator {
    private final static int GENERATE_COUNT = 3;
    private final static int START_NUMBER = 1;
    private final static int END_NUMBER = 9;

    public static Balls generateNumber() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() != GENERATE_COUNT) {
            numbers.add(RandomUtils.nextInt(START_NUMBER, END_NUMBER));
        }

        return new Balls(makeBallsFrom(numbers));
    }

    private static List<BallNumber> makeBallsFrom(Set<Integer> numbers){
        return numbers.stream()
            .map(BallNumber::new)
            .collect(Collectors.toList());
    }

}
