package baseball.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    static InputView inputView;

    @BeforeAll
    static void init() {
        inputView = new InputView();
    }

    @Test
    void 숫자_중_0을_포함하면_예외를_발생시킨다() {
        // given
        InputStream given = new ByteArrayInputStream("012".getBytes());
        System.setIn(given);

        // when
        String actual = assertThrows(
            IllegalArgumentException.class,
            () -> inputView.guessNumber()
        ).getMessage();

        // then
        assertEquals("1 ~ 9 까지의 숫자만 입력할 수 있습니다 ! 게임 종료", actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234", "12345"})
    void 입력이_세자리가_아니면_예외를_발생한다(String input) {
        // given
        InputStream given = new ByteArrayInputStream(input.getBytes());
        System.setIn(given);

        // when
        String actual = assertThrows(
            IllegalArgumentException.class,
            () -> inputView.guessNumber()
        ).getMessage();

        // then
        assertEquals("세 개의 숫자만 입력할 수 있습니다 ! 게임 종료", actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!@#", "asd", "일이삼"})
    void 숫자_외의_문자를_입력하면_예외를_발생시킨다(String input) {
        //given
        InputStream given = new ByteArrayInputStream(input.getBytes());
        System.setIn(given);

        // when
        String actual = assertThrows(
            IllegalArgumentException.class,
            () -> inputView.guessNumber()
        ).getMessage();

        // then
        assertEquals("숫자만 입력할 수 있습니다 ! 게임 종료", actual);
    }

    @Test
    void 세자리_숫자를_입력할_수_있다() {
        // given
        InputStream given = new ByteArrayInputStream("123".getBytes());
        System.setIn(given);

        // when, then
        assertDoesNotThrow(() -> inputView.guessNumber());
    }
}