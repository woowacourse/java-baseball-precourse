package baseball;

import java.util.List;

public class Computer {

	private Balls answerBalls;

	public void determineAnswerBalls() {
		this.answerBalls = Balls.createRandomBalls();
	}

	public GameResult compareBalls(Balls predictionBalls) {
		List<Hint> hints = answerBalls.compareWith(predictionBalls);
		return new GameResult(hints);
	}
}
