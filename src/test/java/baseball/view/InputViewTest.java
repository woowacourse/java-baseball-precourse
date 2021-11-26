package baseball.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 잘못된값_입력() {
        assertThatThrownBy(() -> InputView.inputNumber(new FixedInputStrategy("1234")));
    }
}