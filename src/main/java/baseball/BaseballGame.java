package baseball;

import baseball.io.InputProcessor;
import baseball.io.OutputProcessor;
import baseball.number.Numbers;
import baseball.type.GameStatus;

public class BaseballGame {
	private Numbers computer;
	private GameStatus status;

	private BaseballGame() {
		this.computer = Numbers.create();
		this.status = GameStatus.OPERATION;
	}

	public static BaseballGame create() {
		return new BaseballGame();
	}

	public void start() {
		while (this.status != GameStatus.EXIT) {
			String input = InputProcessor.readValue();
			Numbers player = Numbers.from(input);
			Results results = Results.of(this.computer, player);
			OutputProcessor.printResult(results);
			validateEnd(results);
		}
	}

	private void validateEnd(Results results) {
		if (results.isCorrect()) {
			OutputProcessor.printCorrect();
			GameStatus status = InputProcessor.readGameStatus();
			changeStatus(status);
		}
	}

	private void changeStatus(GameStatus gameStatus) {
		if (gameStatus == GameStatus.RESTART) {
			this.computer = Numbers.create();
			this.status = GameStatus.OPERATION;
		} else if (gameStatus == GameStatus.EXIT) {
			this.status = GameStatus.EXIT;
		}
	}
}
