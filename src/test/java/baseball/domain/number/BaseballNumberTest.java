package baseball.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("BaseballNumber 객체가 리스트에 중복 포함되면 true를 반환")
    @Test
    public void 중복_포함_경우_true를_반환() {
        BaseballNumber baseballNumber = BaseballNumber.of(9);
        List<BaseballNumber> baseballNumbers = Arrays.asList(baseballNumber);

        assertThat(baseballNumber.isDuplicated(baseballNumbers)).isTrue();
    }

    @DisplayName("BasebballNumber 객체가 리스트에 중복 포함되지 않으면 false를 반환")
    @Test
    public void 중복_포함_아닌_경우_false를_반환() {
        BaseballNumber baseballNumber = BaseballNumber.of(1);
        List<BaseballNumber> baseballNumbers = Arrays.asList(BaseballNumber.of(9));

        assertThat(baseballNumber.isDuplicated(baseballNumbers)).isFalse();
    }
}
