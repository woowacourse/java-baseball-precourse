package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class InputUtilsTest {

    final Scanner scanner = new Scanner(System.in);
    final InputUtils inputUtils = InputUtils.of(scanner);

    @Test
    @DisplayName("숫자만 입력 받는다")
    void isInputValueInt() {
        //given
        String tmp = "1455";
        String tmp2 = "123";

        //when
        int number = inputUtils.stringInputValueToInt(tmp);
        int number2 = inputUtils.stringInputValueToInt(tmp2);

        //then
        assertThat(number).isEqualTo(1455);
        assertThat(number2).isEqualTo(123);
    }

    @Test
    @DisplayName("숫자가 아닌 값이 들어 올 때 에러를 표시한다.")
    void inputValueNotInt() {
        //given
        String tmp = "1a2";
        String tmp2 = "1 3";

        //then
        assertThatThrownBy(() -> inputUtils.stringInputValueToInt(tmp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 해주세요");

        assertThatThrownBy(() -> inputUtils.stringInputValueToInt(tmp2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 해주세요");
    }
}