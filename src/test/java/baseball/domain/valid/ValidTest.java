package baseball.domain.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidTest {
    private Valid valid = new ValidImpl();

    @Test
    @DisplayName("숫자_내_중복을_확인한다")
    void 숫자_내_중복() {
        // 123은 숫자 내 중복이 없다.
        boolean result = valid.duplicate("123");
        assertThat(result).isFalse();

        // 111은 숫자 내 중복이 존재한다.
        result = valid.duplicate("111");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("숫자의_범위를_확인한다")
    void 숫자는_3자리수() {
        // 123은 3자리 수 범위 내에 있다.
        boolean result = valid.inRange("123");
        assertThat(result).isTrue();

        // 99은 3자리 수 범위 밖에 있다.
        result = valid.inRange("99");
        assertThat(result).isFalse();

        // 1000은 3자리 수 범위 밖에 있다.
        result = valid.inRange("1000");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("숫자내에 0이 있는지 확인한다.")
    void 숫자에_0이_있는가() {
        // 123에는 0이 포함되어 있지 않다.
        boolean result = valid.hasZero("123");
        assertThat(result).isFalse();

        // 103에는 0포함 되어있다.
        result = valid.hasZero("103");
        assertThat(result).isTrue();
    }
}
