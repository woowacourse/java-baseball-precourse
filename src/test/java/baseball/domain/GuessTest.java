package baseball.domain;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GuessTest {

    private final int startInclusive = 1;
    private final int endInclusive = 9;
    private final int count = 3;

    @Test
    void input_must_be_a_numeric_value() {
        assertThatThrownBy(() -> {
            new Guess("a12");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("numeric");
    }

    @Test
    void all_digits_must_be_unique() {
        assertThatThrownBy(() -> {
            new Guess("111");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("unique");
    }

    @Test
    void test_validate_range() {
        assertThatThrownBy(() -> {
            new Guess("901");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("less than");
    }

    @Test
    void test_validate_size() {
        assertThatThrownBy(() -> {
            new Guess("12345");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("length");
    }
}