package baseball.pitch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
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

    @Test
    @DisplayName("두 Pitch가 같은지 검증")
    void 두_Pitch가_같은지_검증() {
        Pitch pitch = new Pitch(1, 1);
        // 같은 index, 같은 value는 true
        assertThat(pitch.isSame(new Pitch(1, 1))).isTrue();
        // 같은 index, 다른 value는 false
        assertThat(pitch.isSame(new Pitch(1, 2))).isFalse();
        // 다른 index, 같은 value는 true
        assertThat(pitch.isSame(new Pitch(2, 1))).isFalse();
        // index, value 모두 다름
        assertThat(pitch.isSame(new Pitch(2, 2))).isFalse();
    }
}
