package baseball.model;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumberTest {

    @Test
    void Number의_value를_자리수마다_끊어서_반환한다() {
        // given
        Number number = new Number(123);

        // when
        List<Integer> digits = number.fetchDigits();

        // then
        assertThat(digits).containsExactly(1, 2, 3);
    }

    @Test
    void Number의_value를_변경한다() {
        // given
        Number number = new Number(123);

        // when
        number.setValue(456);

        // then
        assertThat(number.fetchDigits()).containsExactly(4, 5, 6);
    }
}