package model.ball.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BallPositionTest {
    @ParameterizedTest
    @DisplayName("0 ~ 2 범위 밖의 값으로 객체를 생성하면 예외를 발생시킨다.")
    @ValueSource(ints = {-1, 3})
    void evokeExceptionByWrongValue(final int wrongValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> new BallPosition(wrongValue))
                .withMessage("숫자 공이 잘못된 위치를 가집니다.");
    }

    @ParameterizedTest
    @DisplayName("value 필드를 기준으로 동등성을 비교해 결과룰 반환한다.")
    @MethodSource("providePositionValueAndExpected")
    void equals(final int givenValue, final boolean expected) {
        BallPosition ballPosition = new BallPosition(0);
        BallPosition another = new BallPosition(givenValue);
        assertThat(ballPosition.equals(another)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("value 필드를 기준으로 해시코드를 반환한다.")
    @MethodSource("providePositionValueAndExpected")
    void hashCode(final int givenValue, final boolean expected) {
        BallPosition ballPosition = new BallPosition(0);
        BallPosition another = new BallPosition(givenValue);
        int hashCodeOfBallPosition = ballPosition.hashCode();
        int hashCodeOfAnother = another.hashCode();
        assertThat(hashCodeOfAnother == hashCodeOfBallPosition).isEqualTo(expected);
    }

    private static Stream<Arguments> providePositionValueAndExpected() {
        return Stream.of(
                Arguments.of(0, true),
                Arguments.of(1, false)
        );
    }
}