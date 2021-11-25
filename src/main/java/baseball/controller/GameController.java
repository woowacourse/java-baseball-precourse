package baseball.controller;

import baseball.GameState;
import baseball.domain.AnswerNumber;
import baseball.util.RandomNumberGenerator;

public class GameController {
	private final AnswerNumber answerNumber;

	public GameController() {
		answerNumber = new AnswerNumber();
	}

	public void startGame() {
		answerNumber.setAnswer(RandomNumberGenerator.generate());
	}
	}
}
