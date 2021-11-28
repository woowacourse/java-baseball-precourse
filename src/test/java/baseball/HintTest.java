package baseball;

import static baseball.BallType.BALL;
import static baseball.BallType.NOTHING;
import static baseball.BallType.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HintTest {

    @DisplayName("Ball, 위치 값을 받아 볼의 상태 반환")
    @Test
    void getType() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Hint hint = new Hint(balls);
        assertThat(hint.getType(new Ball(1), 0)).isEqualTo(STRIKE);
        assertThat(hint.getType(new Ball(1), 1)).isEqualTo(BALL);
        assertThat(hint.getType(new Ball(4), 0)).isEqualTo(NOTHING);
    }

    @DisplayName("Balls를 비교해 Map에 상태, 개수 저장 및 각 상태 개수 반환")
    @Test
    void setHint() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        Hint hint = new Hint(computer);
        Balls user = new Balls(Arrays.asList(1, 3, 4));
        hint.setHint(user);
        assertThat(hint.strike()).isEqualTo(1);
        assertThat(hint.ball()).isEqualTo(1);
        assertThat(hint.nothing()).isEqualTo(1);
    }
}
