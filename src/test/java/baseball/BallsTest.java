package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BallsTest {

	public static Balls makeBalls(int... intArr) {
		List<Ball> ballList = new ArrayList<>();

		for (int j : intArr) {
			ballList.add(new Ball(j));
		}
		return new Balls(ballList);
	}

	@Test
	public void checkBallsSize() {
		// given
		Balls balls = Balls.makeRandomBalls();

		// when && then
		assertEquals(balls.getSize(), Balls.BALLS_COUNT);

	}

}
