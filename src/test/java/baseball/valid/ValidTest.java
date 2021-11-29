package baseball.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidTest {
    private Valid valid = new ValidImpl();

    @Test
    @DisplayName("숫자_내_중복을_확인한다")
    void 숫자_내_중복() {
        // 123은 숫자 내 중복이 없다.
        boolean result = valid.duplicate(123);
        assertThat(result).isFalse();

        // 111은 숫자 내 중복이 존재한다.
        result = valid.duplicate(111);
        assertThat(result).isTrue();
    }
}
