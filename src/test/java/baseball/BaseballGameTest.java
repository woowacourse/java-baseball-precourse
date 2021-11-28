package baseball;

import org.junit.jupiter.api.Test;

class BaseballGameTest {
	final BaseballGame baseballGame = new BaseballGame("425", "456");
	final BaseballGame baseballGame2 = new BaseballGame("425", "789");
	final BaseballGame baseballGame3 = new BaseballGame("425", "425");

	@Test
	void calcStrike() {
		assert 1 == baseballGame.calcStrike();
		assert 0 == baseballGame2.calcStrike();
		assert 3 == baseballGame3.calcStrike();
	}

	@Test
	void calcBall() {
		assert 1 == baseballGame.calcBall();
		assert 0 == baseballGame2.calcBall();
		assert 0 == baseballGame3.calcBall();
	}

	@Test
	void printResult() {
		baseballGame.printResult(1, 2);
		baseballGame2.printResult(0, 0);
		baseballGame3.printResult(0, 3);
	}
}