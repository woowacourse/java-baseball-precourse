package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BallsTest {

	@Test
	public void checkBallsSize() {
		// given
		Balls balls = Balls.makeRandomBalls();

		// when && then
		assertEquals(balls.getSize(), Balls.BALLS_COUNT);

	}

}
