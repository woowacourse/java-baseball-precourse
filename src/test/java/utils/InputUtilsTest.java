package utils;

import baseball.BaseBallGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
        int number = inputUtils.stringToInt(tmp);
        int number2 = inputUtils.stringToInt(tmp2);

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
        assertThatThrownBy(() -> inputUtils.stringToInt(tmp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 해주세요");

        assertThatThrownBy(() -> inputUtils.stringToInt(tmp2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 해주세요");
    }

    @Test
    @DisplayName("3자리를 입력받을 때 통과한다")
    void onlyInputThree() {
        //given
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner testScanner = new Scanner(in);
        InputUtils scannerInputUtils = InputUtils.of(testScanner);

        //when
        String text = scannerInputUtils.getNextLine();

        //then
        assertThat(text).isEqualTo("abc");
    }

    @Test
    @DisplayName("3자리가 아닐때, 에러가 발생한다")
    void onlyInputNotThree() {
        //given
        String tmp = "1234";
        String tmp2 = "43";

        //then
        assertThatThrownBy(() -> inputUtils.validateLength(tmp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리의 수를 입력 해주세요");

        assertThatThrownBy(() -> inputUtils.validateLength(tmp2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리의 수를 입력 해주세요");
    }

    @Test
    @DisplayName("3자리이고 모두 숫자일 때 통과한다")
    void inputThreeIntValue() {
        //given
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner testScanner = new Scanner(in);
        InputUtils scannerInputUtils = InputUtils.of(testScanner);

        //when
        String text = scannerInputUtils.getNextLine();
        int toInt = scannerInputUtils.stringToInt(text);

        //then
        assertThat(toInt).isEqualTo(123);
    }

    @Test
    @DisplayName("3자리이고 하나라도 숫자가 아닐 때, 에러가 발생한다")
    void inputThreeNotIntValue() {
        //given
        String tmp = "1a3";
        String tmp2 = "aaa";

        //then
        assertThatThrownBy(() -> inputUtils.stringToInt(tmp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 해주세요");

        assertThatThrownBy(() -> inputUtils.stringToInt(tmp2))
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
        int number = inputUtils.stringToInt(tmp);
        int number2 = inputUtils.stringToInt(tmp2);
        List<Integer> toListed = inputUtils.intToList(number);
        List<Integer> toListed2 = inputUtils.intToList(number2);

        //then
        assertThat(toListed.get(0)).isEqualTo(1);
        assertThat(toListed.get(1)).isEqualTo(2);
        assertThat(toListed.get(2)).isEqualTo(3);

        assertThat(toListed2.get(0)).isEqualTo(4);
        assertThat(toListed2.get(1)).isEqualTo(5);
        assertThat(toListed2.get(2)).isEqualTo(6);
    }

    @Test
    @DisplayName("게임이 끝났을 시, 1또는 2만 입력 받는다")
    void continueOrNot() {
        //given
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner testScanner = new Scanner(in);
        InputUtils scannerInputUtils = InputUtils.of(testScanner);

        input = "2";
        InputStream in2 = new ByteArrayInputStream(input.getBytes());
        System.setIn(in2);
        Scanner testScanner2 = new Scanner(in2);
        InputUtils scannerInputUtils2 = InputUtils.of(testScanner2);

        //when
        int continueOrNot = scannerInputUtils.getContinueOrNot();
        int continueOrNot2 = scannerInputUtils2.getContinueOrNot();


        //then
        assertThat(continueOrNot).isEqualTo(1);
        assertThat(continueOrNot2).isEqualTo(2);
    }

    @Test
    @DisplayName("게임이 끝났을 시, 문자를 입력할 때, 에러가 발생한다")
    void continueOrNotStringError() {
        //given
        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner testScanner = new Scanner(in);
        InputUtils scannerInputUtils = InputUtils.of(testScanner);

        //then
        assertThatThrownBy(() -> scannerInputUtils.getContinueOrNot())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 해주세요");
    }

    @Test
    @DisplayName("게임이 끝났을 시, 입력받는 숫자가 1또는 2가 아닐 때, 에러가 발생한다")
    void continueOrNotRangeError() {
        //given
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner testScanner = new Scanner(in);
        InputUtils scannerInputUtils = InputUtils.of(testScanner);

        //then
        assertThatThrownBy(() -> scannerInputUtils.getContinueOrNot())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1또는 2를 입력해주세요");
    }

    @Test
    @DisplayName("게임이 끝났을 시, 입력받는 숫자가 1이면 true를 반환한다")
    void chooseContinue() {
        //given
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner testScanner = new Scanner(in);
        BaseBallGame baseBallGame = BaseBallGame.of(testScanner);

        //when
        boolean chooseContinue = baseBallGame.isContinueOrNot();

        //then
        assertThat(chooseContinue).isEqualTo(true);
    }

    @Test
    @DisplayName("게임이 끝났을 시, 입력받는 숫자가 2이면 false를 반환한다")
    void chooseNot() {
        //given
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner testScanner = new Scanner(in);
        BaseBallGame baseBallGame = BaseBallGame.of(testScanner);

        //when
        boolean chooseContinue = baseBallGame.isContinueOrNot();

        //then
        assertThat(chooseContinue).isEqualTo(false);
    }
}
