package baseball.domain.pitch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PitchTest {
    private Pitch pitch = new Pitch(1, 1);
    boolean result;
    @BeforeEach
    void init() {
        result = false;
    }

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
        assertThat(pitch.isStrike(new Pitch(1, 1))).isTrue();
        // 같은 index, 다른 value는 false
        assertThat(pitch.isStrike(new Pitch(1, 2))).isFalse();
        // 다른 index, 같은 value는 true
        assertThat(pitch.isStrike(new Pitch(2, 1))).isFalse();
        // index, value 모두 다름
        assertThat(pitch.isStrike(new Pitch(2, 2))).isFalse();
    }

    @Test
    @DisplayName("볼 판별")
    void 볼_판별() {
        // 같은 값 다른 인덱스는 볼이다.
        result = pitch.isBall(new Pitch(2, 1));
        assertThat(result).isTrue();

        // 값과 인덱스가 모두 같으면 볼이 아니다.
        result = pitch.isBall(new Pitch(1, 1));
        assertThat(result).isFalse();

        // 값이 다르면 인덱스가 아니다.
        result = pitch.isBall(new Pitch(1, 3));
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("스트라이크 판별")
    void 스트라이크_판별() {
        // 인덱스와 값이 모두 같으면 스트라이크이다.
        result = pitch.isStrike(new Pitch(1, 1));
        assertThat(result).isTrue();

        // 그렇지 않으면 전부 스트라이크가 아니다.
        result = pitch.isStrike(new Pitch(1, 2));
        assertThat(result).isFalse();

        result = pitch.isStrike(new Pitch(2, 1));
        assertThat(result).isFalse();
    }
}
