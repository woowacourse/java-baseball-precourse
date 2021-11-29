package model.ball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import model.ComparisonResult;

public class Baseballs {
    private static final int NUMBER_OF_BALLS = 3;
    private final List<Baseball> values;

    public Baseballs(final List<Integer> numbers) {
        validateCountOfBallNumbers(numbers.size());
        validateOverlap(numbers.size(), (int) numbers.stream().distinct().count());
        values = initialize(numbers);
    }

    private List<Baseball> initialize(final List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(index -> new Baseball(numbers.get(index), index))
                .collect(Collectors.toList());
    }

    private void validateCountOfBallNumbers(final int countOfNumbers) {
        if (countOfNumbers != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException("숫자 공들은 3개여야 합니다");
        }
    }

    private void validateOverlap(final int countOfNumbers, final int distinctCountOfNumbers) {
        if (countOfNumbers != distinctCountOfNumbers) {
            throw new IllegalArgumentException("숫자 공들 간에 중복이 있습니다.");
        }
    }

    public List<ComparisonResult> compare(final Baseballs others) {
        return values.stream()
                .map(standardBall -> compare(standardBall, others))
                .collect(Collectors.toList());
    }

    private ComparisonResult compare(final Baseball standardBall, final Baseballs others) {
        return others.values.stream()
                .map(standardBall::compare)
                .filter(result -> result == ComparisonResult.STRIKE || result == ComparisonResult.BALL)
                .findFirst()
                .orElse(ComparisonResult.FAIL);
    }
}
