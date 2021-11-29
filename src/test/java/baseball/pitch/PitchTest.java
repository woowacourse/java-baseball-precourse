package baseball.pitch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PitchTest {
    @Test
    @DisplayName("각 자리수가 1~9의 값인지 검증")
    void 각_자리수_1부터9_검증하기() {
        // 1은 유효한 숫자이다.
        boolean result = new Pitch(1, 1).isValid();
        assertThat(result).isTrue();

        // 0은 유효하지 않은 숫자이다.
        result = new Pitch(1, 0).isValid();
        assertThat(result).isFalse();
    }
}
