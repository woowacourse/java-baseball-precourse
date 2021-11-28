package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    @DisplayName("1~9인 수인지 검사")
    @Test
    void validateScope() {
        assertThatThrownBy(() -> new Ball(0))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("같은 수를 가진 Ball 비교")
    @Test
    void equals() {
        Ball ball1 = new Ball(1);
        assertThat(ball1.equals(new Ball(1))).isTrue();
        assertThat(ball1.equals(new Ball(2))).isFalse();
    }

}
