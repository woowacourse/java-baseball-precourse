package baseball;

public class Computer {

	private Balls answerBalls;

	public void determineAnswerBalls() {
		this.answerBalls = Balls.generateRandomBalls();
	}

	public GameResult compareBalls(Balls predictionBalls) {
		predictionBalls.totalReward(predictionBalls);
		return new GameResult(strike, ball - strike);
	}
}
