package model.ball.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BallNumberTest {
    @ParameterizedTest
    @DisplayName("1~9 범위의 정수가 아닌 값으로 BallNumber 객체를 생성하면 예외를 발생시킨다.")
    @ValueSource(ints = {0, 10})
    void evokeExceptionByWrongInput(final int wrongInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> new BallNumber(wrongInput))
                .withMessage("숫자의 범위는 1 ~ 9 입니다.");
    }

    @ParameterizedTest
    @DisplayName("숫자를 기준으로 동등성을 비교해 결과를 반환한다.")
    @MethodSource("provideNumberAndExpected")
    void equals(final int givenValue, final boolean expected) {
        BallNumber ballNumber = new BallNumber(1);
        BallNumber another = new BallNumber(givenValue);
        boolean actual = ballNumber.equals(another);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("숫자를 기준으로 해시코드를 반환한다.")
    @MethodSource("provideNumberAndExpected")
    void hashCode(final int givenValue, final boolean expected) {
        BallNumber ballNumber = new BallNumber(1);
        BallNumber another = new BallNumber(givenValue);
        int hashCodeOfBallNumber = ballNumber.hashCode();
        int hashCodeOfAnother = another.hashCode();
        assertThat(hashCodeOfBallNumber == hashCodeOfAnother).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumberAndExpected() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, false)
        );
    }
}