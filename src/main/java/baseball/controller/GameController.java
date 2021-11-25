package baseball.controller;

import baseball.GameState;
import baseball.domain.AnswerNumber;
import baseball.util.RandomNumberGenerator;
import baseball.validator.InputValidator;
import baseball.view.InputView;

public class GameController {
	private static GameState gameState;

	public void init() {
		gameState = GameState.PLAY;
		AnswerNumber.setAnswer(RandomNumberGenerator.generate());
	}

	public String inputPlayerNumber() {
		String number = InputView.inputNumber();
		InputValidator inputValidator = new InputValidator(number);
		if (!inputValidator.validateNumber()) {
			throw new IllegalArgumentException("유효하지 않은 데이터입니다.");
		}
		return number;
	}

	public void startGame() {
		init();
		do {
			String playerNumber = inputPlayerNumber();
		} while (gameState == GameState.PLAY);
	}
	}
}
