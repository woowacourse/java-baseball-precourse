package baseball.computer;

import baseball.BaseBall;
import baseball.generator.BallGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static baseball.BaseBallPosition.MAX_POSITION;
import static baseball.BaseBallPosition.MIN_POSITION;
import static java.util.stream.Collectors.toList;

public class Computer {
    private static final int PADDING = 1;
    private final List<BaseBall> baseBalls;

    Computer(List<Integer> baseBalls) {
        this.baseBalls = IntStream.rangeClosed(MIN_POSITION, MAX_POSITION)
                .mapToObj(position -> new BaseBall(position, baseBalls.get(position - PADDING)))
                .collect(toList());
    }

    public static Computer newGame(BallGenerator ballGenerator) {
        List<Integer> numbers = makeNumbers(ballGenerator);
        return new Computer(numbers);
    }

    private static List<Integer> makeNumbers(BallGenerator ballGenerator) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            numbers.add(ballGenerator.getNumber(i));
        }
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(baseBalls, computer.baseBalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseBalls);
    }
}
