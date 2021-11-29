package model.ball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static model.ComparisonResult.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import model.ComparisonResult;

class BaseballsTest {
    @ParameterizedTest
    @DisplayName("숫자의 개수가 3개가 아니면 예외를 발생시킨다.")
    @MethodSource("provideWrongNumbers")
    void evokeExceptionByWrongNumberOfBallNumbers(final List<Integer> wrongNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Baseballs(wrongNumbers))
                .withMessage("숫자 공들은 3개여야 합니다");
    }

    private static Stream<Arguments> provideWrongNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(1, 2, 3, 4))
        );
    }

    @Test
    @DisplayName("숫자들 간에 중복이 있으면 예외를 발생시킨다.")
    void evokeExceptionByOverlap() {
        List<Integer> overlappedNumbers = Arrays.asList(1, 2, 2);
        assertThatIllegalArgumentException().isThrownBy(() -> new Baseballs(overlappedNumbers))
                .withMessage("숫자 공들 간에 중복이 있습니다.");
    }

    @ParameterizedTest
    @DisplayName("Balls 객체를 받아 비교 결과를 반환한다.")
    @MethodSource("provideBallsAndExceptedResult")
    void compare(final List<Integer> otherNumbers, List<ComparisonResult> expected) {
        Baseballs balls = new Baseballs(Arrays.asList(1, 2, 3));
        Baseballs otherBalls = new Baseballs(otherNumbers);
        List<ComparisonResult> actual = balls.compare(otherBalls);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideBallsAndExceptedResult() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(STRIKE, STRIKE, STRIKE)),
                Arguments.of(Arrays.asList(1, 2, 4), Arrays.asList(STRIKE, STRIKE, FAIL)),
                Arguments.of(Arrays.asList(1, 3, 2), Arrays.asList(STRIKE, BALL, BALL)),
                Arguments.of(Arrays.asList(4, 5, 6), Arrays.asList(FAIL, FAIL, FAIL))
        );
    }
}