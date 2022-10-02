package baseball;

import static baseball.BallsTest.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ResultTest {

	@Test
	void checkAllBallResult() {
		// given
		Balls userBalls = makeBalls(2, 3, 1);
		Balls comBalls = makeBalls(1, 2, 3);
		assertEquals(new Result(0, 3),
			Result.checkBalls(comBalls, userBalls));
	}

	@Test
	void checkAllStrikeResult() {
		// given
		Balls userBalls = makeBalls(1, 2, 3);
		Balls comBalls = makeBalls(1, 2, 3);
		assertEquals(new Result(3, 0),
			Result.checkBalls(comBalls, userBalls));
	}

	@Test
	void checkOneStrikeTwoBallResult() {
		// given
		Balls userBalls = makeBalls(1, 2, 3);
		Balls comBalls = makeBalls(1, 3, 2);
		assertEquals(new Result(1, 2),
			Result.checkBalls(comBalls, userBalls));
	}

	@Test
	void checkNothingResult() {
		// given
		Balls userBalls = makeBalls(1, 2, 3);
		Balls comBalls = makeBalls(4, 5, 6);
		assertEquals(new Result(0, 0),
			Result.checkBalls(comBalls, userBalls));
	}

	@Test
	void checkStrikeMessage() {
		int strike = 2;
		int ball = 0;
		assertEquals(new Result(strike, ball).getResultMessage(),
			"2스트라이크");
	}

	@Test
	void checkBallMessage() {
		int strike = 0;
		int ball = 2;
		assertEquals(new Result(strike, ball).getResultMessage(),
			"2볼");
	}

	@Test
	void checkBallStrikeMessage() {
		int strike = 1;
		int ball = 2;
		assertEquals(new Result(strike, ball).getResultMessage(),
			"2볼 1스트라이크");
	}

	@Test
	void checkNothingMessage() {
		int strike = 0;
		int ball = 0;
		assertEquals(new Result(strike, ball).getResultMessage(),
			"낫싱");
	}

}
