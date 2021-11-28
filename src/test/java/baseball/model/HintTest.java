package baseball.model;

import baseball.model.Referee.Hint;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HintTest {

    @Test
    void getHint() {
        Hint hint = new Hint();
        assertThat(hint.getHint("123", "123")).isEqualTo("3 스트라이크");
    }
}