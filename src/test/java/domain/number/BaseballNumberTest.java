package domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @DisplayName("1 - 9 범위의 값에서만 BaseballNumber 객체가 생성 정상")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void BaseballNumber_객체_생성_정상(int baseballNumber) {
        assertThatCode(() -> {
            BaseballNumber.of(baseballNumber);
        }).doesNotThrowAnyException();
    }

    @DisplayName("1 - 9 범위가 아닌 경우, BaseballNumber 객체 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    public void BaseballNumber_객체_생성_예외_발생(int baseballNumber) {
        assertThatThrownBy(() -> {
            BaseballNumber.of(baseballNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
