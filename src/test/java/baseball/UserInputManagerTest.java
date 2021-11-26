package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputManagerTest {
    private final InputStream standardIn = System.in;
    private final UserInputManager userInputManager = new UserInputManager();

    @Test
    void 사용자가_입력한_수를_int배열로_리턴() {
        String input = "465";
        setInput(input);
        int[] result = userInputManager.getNumbers();
        assertThat(result).isEqualTo(new int[]{4, 6, 5});
    }

    @Test
    void 사용자가_입력한_수가_글자수가_틀리면_예외_발생() {
        String tooLongInput = "1234";
        setInput(tooLongInput);
        assertThatThrownBy(userInputManager::getNumbers).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_입력한_수가_1에서_9의_숫자가_아니면_예외_발생() {
        String specialCharacterInput = "!62";
        setInput(specialCharacterInput);
        assertThatThrownBy(userInputManager::getNumbers).isInstanceOf(IllegalArgumentException.class);
    }

    @AfterEach
    void 표준인풋스트림으로_복구() {
        System.setIn(standardIn);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
