package domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

class BaseballNumberTest {

    @DisplayName("1 - 9 범위의 값에서만 BaseballNumber 객체가 정상 생성된다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void BaseballNumber_객체_정상_생성(int baseballNumber) {
        assertThatCode(() -> {
            new BaseballNumber(baseballNumber);
        }).doesNotThrowAnyException();
    }
}
