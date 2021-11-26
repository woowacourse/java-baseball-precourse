package baseball.view;

import baseball.model.Balls;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    void 잘못된값_입력() {
        assertThatThrownBy(() -> InputView.inputNumber(new FixedInputStrategy("1234")));
        assertThatThrownBy(() -> InputView.inputNumber(new FixedInputStrategy("12")));
        assertThatThrownBy(() -> InputView.inputNumber(new FixedInputStrategy("abc")));
    }

    @Test
    void 정상값입력후_Balls객체_생성여부() {
        Balls balls = InputView.inputNumber(new FixedInputStrategy("456"));
        assertThat(balls).isEqualTo(new Balls(4, 5, 6));
    }
}