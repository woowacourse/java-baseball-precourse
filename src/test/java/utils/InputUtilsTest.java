package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
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
        int number = inputUtils.inputValueToInt(tmp);
        int number2 = inputUtils.inputValueToInt(tmp2);

        //then
        assertThat(number).isEqualTo(1455);
        assertThat(number2).isEqualTo(123);
    }

    @Test
    @DisplayName("숫자가 아닌 값이 들어 올 때, 에러가 발생한다")
    void inputValueNotInt() {
        //given
        String tmp = "1a2";
        String tmp2 = "1 3";

        //then
        assertThatThrownBy(() -> inputUtils.inputValueToInt(tmp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 해주세요");

        assertThatThrownBy(() -> inputUtils.inputValueToInt(tmp2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 해주세요");
    }

    @Test
    @DisplayName("3자리 입력받기")
    void onlyInputThree() {
        //given
        String tmp = "123";
        String tmp2 = "432";

        //when
        String text = inputUtils.checkLength(tmp);
        String text2 = inputUtils.checkLength(tmp2);

        //then
        assertThat(text.length()).isEqualTo(3);
        assertThat(text2.length()).isEqualTo(3);
    }

    @Test
    @DisplayName("3자리가 아닐때, 에러가 발생한다")
    void onlyInputNotThree() {
        //given
        String tmp = "1234";
        String tmp2 = "43";

        //then
        assertThatThrownBy(() -> inputUtils.checkLength(tmp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리의 수를 입력 해주세요");

        assertThatThrownBy(() -> inputUtils.checkLength(tmp2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리의 수를 입력 해주세요");
    }

    @Test
    @DisplayName("3자리이고 모두 숫자일 때")
    void inputThreeIntValue() {
        //given
        String tmp = "123";
        String tmp2 = "432";

        //when
        String text = inputUtils.checkLength(tmp);
        String text2 = inputUtils.checkLength(tmp2);
        int number = inputUtils.inputValueToInt(text);
        int number2 = inputUtils.inputValueToInt(text2);

        //then
        assertThat(number).isEqualTo(123);
        assertThat(number2).isEqualTo(432);
    }

    @Test
    @DisplayName("3자리이고 하나라도 숫자가 아닐 때, 에러가 발생한다")
    void inputThreeNotIntValue() {
        //given
        String tmp = "1a3";
        String tmp2 = "aaa";

        //when
        String text = inputUtils.checkLength(tmp);
        String text2 = inputUtils.checkLength(tmp2);

        //then
        assertThatThrownBy(() -> inputUtils.inputValueToInt(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 해주세요");

        assertThatThrownBy(() -> inputUtils.inputValueToInt(text2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 해주세요");
    }

    @Test
    @DisplayName("int값을 List<Integer>로 반환한다")
    void intValueToList() {
        //given
        String tmp = "123";
        String tmp2 = "456";

        //when
        int number = inputUtils.inputValueToInt(tmp);
        int number2 = inputUtils.inputValueToInt(tmp2);
        List<Integer> toListed = inputUtils.intValueToList(number);
        List<Integer> toListed2 = inputUtils.intValueToList(number2);

        //then
        assertThat(toListed.get(0)).isEqualTo(1);
        assertThat(toListed.get(1)).isEqualTo(2);
        assertThat(toListed.get(2)).isEqualTo(3);

        assertThat(toListed2.get(0)).isEqualTo(4);
        assertThat(toListed2.get(1)).isEqualTo(5);
        assertThat(toListed2.get(2)).isEqualTo(6);
    }
}
