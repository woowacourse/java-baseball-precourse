package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallTest {

	private Ball ball;

	@BeforeEach
	void setUp() {
		ball = new Ball(1, 1);
	}

	@Test
	void 같은수_같은자리_스트라이크() {
		assertThat(ball.compare(new Ball(1, 1)).isStrike()).isTrue();
	}

	@Test
	void 같은수_다른자리_볼() {
		assertThat(ball.compare(new Ball(1, 2)).isBall()).isTrue();
	}

	@Test
	void 같은수_없음_낫싱() {
		assertThat(ball.compare(new Ball(2, 2)).isNothing()).isTrue();
	}
}
