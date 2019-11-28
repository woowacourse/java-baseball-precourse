package computer;

import baseball.BaseBalls;
import baseball.generator.BallGenerator;
import computer.result.Result;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static baseball.BaseBallPosition.MAX_POSITION;
import static baseball.BaseBallPosition.MIN_POSITION;
import static java.util.stream.Collectors.toList;

public class Computer {

    private final BaseBalls baseBalls;

    Computer(List<Integer> numbers) {
        this.baseBalls = new BaseBalls(numbers);
    }

    public static Computer newGame(BallGenerator ballGenerator) {
        List<Integer> numbers = makeNumbers(ballGenerator);
        return new Computer(numbers);
    }

    private static List<Integer> makeNumbers(BallGenerator ballGenerator) {
        return IntStream.rangeClosed(MIN_POSITION, MAX_POSITION)
                .mapToObj(ballGenerator::getNumber)
                .collect(toList());
    }

    public List<Result> getResults(BaseBalls compares) {
        return compares.getBaseBalls().stream()
                .map(compare -> Result.getResult(baseBalls, compare))
                .collect(toList());
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
