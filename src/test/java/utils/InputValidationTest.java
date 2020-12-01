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
    public void 입력값이_숫자인지_검증한다() throws Exception {
        //given
        String str = "-29";

        //when
        boolean isNumber = str.chars().allMatch(Character::isDigit);

        //then
        System.out.println(isNumber);
        assertThat(isNumber).isFalse();
    }

    @Test
    public void 입력값_중복여부_검증한다() throws Exception {
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

    @Test
    public void 재시작_종료_입력값_검증한다() throws Exception {
        //given
        int input = 4;

        //when

        //then
        if((input != 1) && (input != 2)) {
            System.out.println("입력값 범위를 벗어났습니다.");
        } else {
            System.out.println("success");
        }
    }
}