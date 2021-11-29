package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameTest {
    private final Game game = new Game() {
        @Override
        List<Integer> generateThreeRandomNumbers() {
            return Arrays.asList(1, 2, 3);
        }
    };

    @ParameterizedTest
    @DisplayName("시도 한번에 대한 결과를 반환한다.")
    @MethodSource("provideNumbersAndExpectedResult")
    void getResult(final List<Integer> userNumbers, final int expectedStrike, final int expectedBall) {
        game.tryOnce(userNumbers);
        BallCount ballCount = game.getResult();
        int actualStrike = ballCount.getStrike();
        int actualBall = ballCount.getBall();
        assertAll(
                () -> assertThat(actualStrike).isEqualTo(expectedStrike),
                () -> assertThat(actualBall).isEqualTo(expectedBall)
        );
    }

    private static Stream<Arguments> provideNumbersAndExpectedResult() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), 3, 0),
                Arguments.of(Arrays.asList(1, 2, 4), 2, 0),
                Arguments.of(Arrays.asList(1, 3, 2), 1, 2),
                Arguments.of(Arrays.asList(3, 1, 2), 0, 3),
                Arguments.of(Arrays.asList(4, 5, 6), 0, 0)
        );
    }

    @ParameterizedTest
    @DisplayName("게임이 끝나지 않았는지 반환한다.")
    @MethodSource("provideNumbersAndExpected")
    void isOver(final List<Integer> userNumbers, final boolean expected) {
        game.tryOnce(userNumbers);
        boolean actual = game.isNotOver();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbersAndExpected() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), false),
                Arguments.of(Arrays.asList(1, 2, 4), true),
                Arguments.of(Arrays.asList(1, 3, 2), true),
                Arguments.of(Arrays.asList(4, 5, 6), true)
        );
    }
}