package baseball;

public class Computer {

	private Balls answerBalls;

	public void determineAnswerBalls() {
		this.answerBalls = Balls.generateRandomBalls();
	}

	public GameResult compareBalls(Balls predictionBalls) {
		answerBalls.totalReward(predictionBalls);
		return new GameResult();
	}
}
