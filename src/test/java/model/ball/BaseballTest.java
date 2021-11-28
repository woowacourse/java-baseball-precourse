package model.ball;

import static org.assertj.core.api.Assertions.assertThat;
import static model.ComparisonResult.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import model.ComparisonResult;

class BaseballTest {
    @ParameterizedTest
    @DisplayName("다른 공 객체를 받아 숫자와 위치를 기준으로 비교 결과를 반환한다.")
    @MethodSource("provideBallAndExpected")
    void compare(final Baseball another, final ComparisonResult expected) {
        Baseball ball = new Baseball(5, 1);
        ComparisonResult actual = ball.compare(another);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideBallAndExpected() {
        return Stream.of(
                Arguments.of(new Baseball(5, 1), STRIKE),
                Arguments.of(new Baseball(5, 2), BALL),
                Arguments.of(new Baseball(3, 0), FAIL)
        );
    }
}