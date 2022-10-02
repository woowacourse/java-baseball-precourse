package baseball;

import static baseball.BallsTest.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ResultTest {

	@Test
	void checkAllBallResult() {
		// given
		Balls userBalls = makeBalls(1, 2, 3);
		Balls comBalls = makeBalls(1, 2, 3);
		assertEquals(new Result(3, 0),
			Result.checkBalls(comBalls, userBalls));
	}
}
