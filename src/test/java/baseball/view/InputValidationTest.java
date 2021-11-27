package baseball.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.InputValidation;

class InputValidationTest {

    static InputValidation validator;

    @BeforeAll
    static void init() {
        validator = new InputValidation();
    }

    @ParameterizedTest
    @CsvSource({"012,1 ~ 9 까지의 숫자만 입력할 수 있습니다 ! 게임 종료",
        "1,세 개의 숫자만 입력할 수 있습니다 ! 게임 종료", "1234,세 개의 숫자만 입력할 수 있습니다 ! 게임 종료",
        "!@#,숫자만 입력할 수 있습니다 ! 게임 종료", "asd,숫자만 입력할 수 있습니다 ! 게임 종료", "일이삼,숫자만 입력할 수 있습니다 ! 게임 종료"})
    void 잘못된_입력을_검증할_수_있다(String given, String expected) {
        // when then
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () ->
            validator.validateGuessNumber(given));
        assertEquals(expected, actual.getMessage());
    }

    @Test
    void 세자리_숫자를_입력할_수_있다() {
        // given
        String given = "123";

        // when, then
        assertDoesNotThrow(() -> validator.validateGuessNumber(given));
    }
}