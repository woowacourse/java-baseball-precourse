package baseball;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Baseballs {

    public static final int BALLS_CONTAINER_SIZE = 3;
    private static final int ZERO = 0;
    public static final String INPUT_DELIMITER = "";
    private static final String SIZE_ERROR_MESSAGE = "올바른 양의 숫자가 입력되지 않았습니다.";
    private static final String NON_NUMERIC_ERROR_MESSAGE = "숫자가 아닌 정보가 입력되었습니다.";
    private static final String ZERO_FOUND_ERROR_MESSAGE = "0은 포함할 수 없습니다.";
    private static final String DUPLICATE_FOUND_ERROR_MESSAGE = "중복되는 수는 포함 수 없습니다.";

    private final List<Integer> balls;

    public Baseballs(List<Integer> balls) {
        this.balls = balls;
    }

    public Baseballs(String rawBallsInput) {
        validate(rawBallsInput);
        balls = Stream.of(rawBallsInput.split(INPUT_DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public List<Integer> getBalls() {
        return balls;
    }

    private void validate(String rawBallsInput) {
        validateSize(rawBallsInput);
        validateNumerical(rawBallsInput);
        validateNoZero(rawBallsInput);
        validateNoDuplicate(rawBallsInput);
    }

    private void validateSize(String rawBallsInput) {
        if (hasWrongSize(rawBallsInput)) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private boolean hasWrongSize(String input) {
        return input.length() != BALLS_CONTAINER_SIZE;
    }

    private void validateNumerical(String rawBallsInput) {
        if (hasNonNumerical(rawBallsInput)) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    private boolean hasNonNumerical(String input) {
        return Stream.of(input.split(INPUT_DELIMITER))
            .anyMatch(x -> !Character.isDigit(x.charAt(0)));
    }

    private void validateNoZero(String rawBallsInput) {
        if (hasZero(rawBallsInput)) {
            throw new IllegalArgumentException(ZERO_FOUND_ERROR_MESSAGE);
        }
    }

    private boolean hasZero(String input) {
        return Stream.of(input.split(INPUT_DELIMITER))
            .map(Integer::parseInt)
            .anyMatch(x -> x == ZERO);
    }

    private void validateNoDuplicate(String rawBallsInput) {
        if (hasDuplicate(rawBallsInput)) {
            throw new IllegalArgumentException(DUPLICATE_FOUND_ERROR_MESSAGE);
        }
    }

    private boolean hasDuplicate(String input) {
        Set<Integer> temporaryBalls = Stream.of(input.split(INPUT_DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toSet());
        return temporaryBalls.size() != BALLS_CONTAINER_SIZE;
    }
}
