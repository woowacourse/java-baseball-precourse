package baseball;

public class Computer {

	private Balls answerBalls;

	public void determineAnswerBalls() {
		this.answerBalls = Balls.generateRandomBalls();
	}

	public Hint compareBalls(Balls predictionBalls) {
		
		return new Hint(strike, ball - strike);
	}
}
