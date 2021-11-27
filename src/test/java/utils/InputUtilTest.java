package utils;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static constant.Constant.INPUT_ERROR_DUPLICATE;
import static constant.Constant.INPUT_ERROR_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputUtilTest {

    @DisplayName("옳바른 입력값 테스트")
    @Test
    void validInputTest() {
        // given
        final InputUtil inputUtil = new InputUtil();
        System.setIn(new ByteArrayInputStream("123".getBytes()));

        // when
        final List<Integer> userInput = inputUtil.getPlayerAnswer();

        // then
        Integer[] resultArr = {1, 2, 3};
        List<Integer> result = Arrays.asList(resultArr);
        assertThat(userInput).isEqualTo(result);
    }

    @DisplayName("중복된 입력값 테스트")
    @Test
    void DuplicateInputTest() {
        // given
        final InputUtil inputUtil = new InputUtil();
        System.setIn(new ByteArrayInputStream("996".getBytes()));

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> inputUtil.getPlayerAnswer());

        // then
        assertThat(exception.getMessage()).isEqualTo(INPUT_ERROR_DUPLICATE);
    }

    @DisplayName("잘못된 입력값 길이 테스트 (2자리 수)")
    @Test
    void invalidInputLengthTest1() {
        // given
        final InputUtil inputUtil = new InputUtil();
        System.setIn(new ByteArrayInputStream("96".getBytes()));

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> inputUtil.getPlayerAnswer());

        // then
        assertThat(exception.getMessage()).isEqualTo(INPUT_ERROR_LENGTH);
    }

    @DisplayName("잘못된 입력값 길이 테스트 (4자리 수)")
    @Test
    void invalidInputLengthTest2() {
        // given
        final InputUtil inputUtil = new InputUtil();
        System.setIn(new ByteArrayInputStream("9612".getBytes()));

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class, () -> inputUtil.getPlayerAnswer());

        // then
        assertThat(exception.getMessage()).isEqualTo(INPUT_ERROR_LENGTH);
    }

}