package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//- [ ] Ball 끼리 비교할 수 있는 기능 구현

public class BallTest {

    @DisplayName("1~9인 수인지 검사")
    @Test
    void validateScope() {
        assertThatThrownBy(() -> new Ball(0))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
