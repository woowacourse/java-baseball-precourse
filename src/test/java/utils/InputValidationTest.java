package utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidationTest {

    @Test
    public void 입력값_길이가_3인지_검증한다() throws Exception {
        //given
        String str = "123";

        //when

        //then
        assertThat(str.length()).isEqualTo(3);
    }

    @Test
    public void 입력값_범위가_1_9인지_검증한다() throws Exception {
        //given
        String str = "962";

        //when
        boolean isOutOfRange = Arrays.stream(str.split(""))
                .mapToInt(Integer::parseInt)
                .filter(n -> (n > 0 && n < 10))
                .count() != 3;

        //then
        assertThat(isOutOfRange).isFalse();
    }

    @Test
    public void 입력값_중복여부를_검증한다() throws Exception {
        //given
        String str = "346";

        //when
        boolean isDuplicate = Arrays.stream(str.split(""))
                .mapToInt(Integer::parseInt)
                .distinct()
                .count() != str.length();

        //then
        assertThat(isDuplicate).isFalse();
    }

}