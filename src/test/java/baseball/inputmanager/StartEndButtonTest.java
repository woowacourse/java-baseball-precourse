package baseball.inputmanager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StartEndButtonTest {
    private final InputStream standardIn = System.in;
    private final StartEndButton startEndButton = new StartEndButton();

    @Test
    void 사용자가_입력한_수가_글자수가_틀리면_예외_발생() {
        String tooLongInput = "12";
        setInput(tooLongInput);
        assertThatThrownBy(startEndButton::getInput).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_입력한_수가_1에서_2의_숫자가_아니면_예외_발생() {
        String specialCharacterInput = "!";
        setInput(specialCharacterInput);
        assertThatThrownBy(startEndButton::getInput).isInstanceOf(IllegalArgumentException.class);
    }

    @AfterEach
    void 표준인풋스트림으로_복구() {
        System.setIn(standardIn);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}
