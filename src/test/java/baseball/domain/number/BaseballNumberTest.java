package baseball.domain.number;

import baseball.domain.exception.BaseballNumberRangeException;
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
            BaseballNumber.valueOf(baseballNumber);
        }).doesNotThrowAnyException();
    }

    @DisplayName("1 - 9 범위의 값이 아니면 BaseballNumber 객체 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    public void BaseballNumber_객체_생성_예외_발생(int baseballNumber) {
        assertThatThrownBy(() -> {
            BaseballNumber.valueOf(baseballNumber);
        }).isInstanceOf(BaseballNumberRangeException.class);
    }
}
