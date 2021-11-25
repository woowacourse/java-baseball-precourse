package baseball.controller;

import baseball.GameState;
import baseball.domain.AnswerNumber;
import baseball.util.RandomNumberGenerator;

public class GameController {
	public void startGame() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		AnswerNumber.setAnswer(randomNumberGenerator.generate());
	}
}
