package baseball;

import static baseball.BallType.BALL;
import static baseball.BallType.NOTHING;
import static baseball.BallType.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HintTest {

	Hint hint;

	@BeforeEach
	void setUp() {
		Balls computer = new Balls(Arrays.asList(1, 2, 3));
		Balls user = new Balls(Arrays.asList(1, 3, 4));
		hint = new Hint(computer, user);
	}

	@DisplayName("Ball, 위치 값을 받아 볼의 상태 반환")
	@Test
	void getType() {
		Balls computer = new Balls(Arrays.asList(1, 2, 3));
		assertThat(hint.getType(computer, new Ball(1), 0)).isEqualTo(STRIKE);
		assertThat(hint.getType(computer, new Ball(3), 1)).isEqualTo(BALL);
		assertThat(hint.getType(computer, new Ball(4), 2)).isEqualTo(NOTHING);
	}

	@DisplayName("Balls를 비교해 Map에 상태, 개수 저장 및 각 상태 개수 반환")
	@Test
	void setHint() {
		assertThat(hint.strike()).isEqualTo(1);
		assertThat(hint.ball()).isEqualTo(1);
		assertThat(hint.nothing()).isEqualTo(1);
	}
}