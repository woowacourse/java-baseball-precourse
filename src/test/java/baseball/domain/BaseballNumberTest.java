package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BaseballNumberTest {
    @Test
    public void 입력값이_세개가_아니면_객체_만들지_않고_예외_발생() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2);

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumberCreator.createBaseballNumber(numbers));
    }

    @Test
    public void 입력값이_0을_포함하면_객체_만들지_않고_예외_발생() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 0);

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumberCreator.createBaseballNumber(numbers));
    }

    @Test
    public void 입력값이_중복된_값을_포함하면_객체_만들지_않고_예외_발생() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 2);

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumberCreator.createBaseballNumber(numbers));
    }
}