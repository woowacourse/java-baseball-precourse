package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.pitching.Pitching;
import baseball.domain.pitching.Pitchings;
import baseball.domain.pitching.exception.PitchingOutOfRangeException;
import baseball.domain.pitching.exception.PitchingsInputNotDigitException;
import baseball.domain.pitching.exception.PitchingsSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("투구들에 대한 테스트")
class PitchingsTest {

    @DisplayName(Pitching.MIN_VALUE + " 보다 작은 값이 포함된 투구들은 만들 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"1" + (Pitching.MIN_VALUE - 1) + "2", "12" + (Pitching.MIN_VALUE - 1),})
    void createContainedLessThanMinValue(final String value) {
        assertThrows(PitchingOutOfRangeException.class, () -> Pitchings.of(value));
    }

    @DisplayName("3자리가 아닌 투구들은 만들 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "12", "1234"})
    void createInvalidSize(final String value) {
        assertThrows(PitchingsSizeException.class, () -> Pitchings.of(value));
    }

    @DisplayName("숫자가 아닌 문자가 포함된 값으로는 투구들을 만들 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"-12", "1#2", "1 2"})
    void createNotOnlyDigit(final String value) {
        assertThrows(PitchingsInputNotDigitException.class, () -> Pitchings.of(value));
    }

    @DisplayName("중복되지 않는 3자리 숫자로 투구들을 만든다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456"})
    void create(final String value) {
        final Pitchings pitchings = Pitchings.of(value);

        assertNotNull(pitchings);
    }

    @DisplayName("같은 위치에 있는 투구가 서로 일치한다.")
    @Test
    void match() {
        final Pitchings base = Pitchings.of("123");
        final Pitchings target = Pitchings.of("123");

        for (int i = 0; i < Pitchings.SIZE; i++) {
            final boolean isMatched = base.match(target, i);

            assertTrue(isMatched);
        }
    }

    @DisplayName("같은 위치에 있는 투구가 일치하지 않는다.")
    @Test
    void matchFailed() {
        final Pitchings base = Pitchings.of("123");
        final Pitchings target = Pitchings.of("456");

        for (int i = 0; i < Pitchings.SIZE; i++) {
            final boolean isMatched = base.match(target, i);

            assertFalse(isMatched);
        }
    }

    @DisplayName("특정 위치에 있는 투구를 포함하고 있다.")
    @Test
    void contain() {
        final Pitchings base = Pitchings.of("123");
        final Pitchings target = Pitchings.of("312");

        for (int i = 0; i < Pitchings.SIZE; i++) {
            final Pitching targetPitching = target.getPitching(i);
            final boolean isMatched = base.contains(targetPitching);

            assertTrue(isMatched);
        }
    }

    @DisplayName("특정 위치에 있는 투구를 포함하고 있지 않다.")
    @Test
    void containFailed() {
        final Pitchings base = Pitchings.of("123");
        final Pitchings target = Pitchings.of("456");

        for (int i = 0; i < Pitchings.SIZE; i++) {
            final Pitching targetPitching = target.getPitching(i);
            final boolean isMatched = base.contains(targetPitching);

            assertFalse(isMatched);
        }
    }

    @DisplayName("랜덤한 투구들을 만든다.")
    @Test
    void generate() {
        final Pitchings pitchings = Pitchings.random();

        assertThat(pitchings).isNotNull();
    }
}