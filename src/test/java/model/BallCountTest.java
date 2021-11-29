package model;

import static org.assertj.core.api.Assertions.assertThat;
import static model.ComparisonResult.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BallCountTest {
    private final List<ComparisonResult> comparisonResults = Arrays.asList(STRIKE, BALL, BALL);
    private final BallCount ballCount = new BallCount(comparisonResults);

    @Test
    @DisplayName("Strike 카운트를 반환한다.")
    void getStrike() {
        int actual = ballCount.getStrike();
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Ball 카운트를 반환한다.")
    void getBall() {
        int actual = ballCount.getBall();
        int expected = 2;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("3스트라이크인지 반환한다.")
    @MethodSource("provideComparisonResultsAndExpectedThreeStrike")
    void isThreeStrike(List<ComparisonResult> comparisonResults, final boolean expected) {
        BallCount ballCount = new BallCount(comparisonResults);
        boolean actual = ballCount.isThreeStrike();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideComparisonResultsAndExpectedThreeStrike() {
        return Stream.of(
                Arguments.of(Arrays.asList(STRIKE, STRIKE, STRIKE), true),
                Arguments.of(Arrays.asList(STRIKE, BALL, BALL), false)
        );
    }


    @ParameterizedTest
    @DisplayName("낫씽인지 반환한다.")
    @MethodSource("provideComparisonResultsAndExpectedNothing")
    void isNothing(final List<ComparisonResult> comparisonResults, final boolean expected) {
        BallCount ballCount = new BallCount(comparisonResults);
        boolean actual = ballCount.isNothing();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideComparisonResultsAndExpectedNothing() {
        return Stream.of(
                Arguments.of(Arrays.asList(FAIL, FAIL, FAIL), true),
                Arguments.of(Arrays.asList(STRIKE, FAIL, FAIL), false)
        );
    }
}
