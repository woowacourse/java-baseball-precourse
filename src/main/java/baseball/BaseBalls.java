package baseball;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static baseball.BaseBallPosition.MAX_POSITION;
import static baseball.BaseBallPosition.MIN_POSITION;
import static baseball.generator.BallGenerator.PADDING;
import static java.util.stream.Collectors.toList;

public class BaseBalls {
    private final List<BaseBall> baseBalls;

    public BaseBalls(List<Integer> numbers) {
        validateSize(numbers);
        this.baseBalls = IntStream.rangeClosed(MIN_POSITION, MAX_POSITION)
                .mapToObj(position -> new BaseBall(position, numbers.get(position - PADDING)))
                .collect(toList());
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("야구공은 3개만 허용됩니다.");
        }
    }

    public boolean isStrike(BaseBall compare) {
        return this.baseBalls.contains(compare);
    }

    public boolean isBall(BaseBall compare) {
        BaseBallNumber baseBallNumber = compare.getBaseBallNumber();

        return baseBalls.stream()
                .map(BaseBall::getBaseBallNumber)
                .collect(toList())
                .contains(baseBallNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBalls baseBalls1 = (BaseBalls) o;
        return Objects.equals(baseBalls, baseBalls1.baseBalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseBalls);
    }
}
