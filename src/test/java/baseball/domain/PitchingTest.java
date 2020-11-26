package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.pitching.Pitching;
import baseball.domain.pitching.exception.PitchingOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("투구에 대한 테스트")
class PitchingTest {

    @DisplayName(Pitching.MIN_VALUE + " 보다 작은 값의 투구는 가져올 수 없다.")
    @Test
    void createLessThanMinValue() {
        final int value = Pitching.MIN_VALUE - 1;

        assertThrows(PitchingOutOfRangeException.class, () -> Pitching.of(value));
    }

    @DisplayName(Pitching.MAX_VALUE + " 보다 큰 값의 투구는 가져올 수 없다.")
    @Test
    void createGreaterThanMaxValue() {
        final int value = Pitching.MAX_VALUE + 1;

        assertThrows(PitchingOutOfRangeException.class, () -> Pitching.of(value));
    }

    @DisplayName(Pitching.MIN_VALUE + "와 " + Pitching.MAX_VALUE + " 사이의 숫자로 투구를 가져올 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {Pitching.MIN_VALUE, 7, Pitching.MAX_VALUE})
    void create(final int value) {
        final Pitching pitching = Pitching.of(value);

        assertThat(pitching).isNotNull();
    }
}