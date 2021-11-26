package baseball.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import baseball.GameState;
import baseball.domain.AnswerNumber;
import baseball.util.RandomNumberGenerator;
import baseball.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
	private static GameState gameState;

	public void init() {
		gameState = GameState.PLAY;
		AnswerNumber.setAnswer(RandomNumberGenerator.generate());
	}

	public List<Integer> inputPlayerNumber() {
		List<Integer> inputNumberList = Stream.of(InputView.inputNumber().split(""))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		InputValidator inputValidator = new InputValidator(inputNumberList);
		if (!inputValidator.validateNumber()) {
			throw new IllegalArgumentException("유효하지 않은 데이터입니다.");
		}
		return inputNumberList;
	}

	public void startGame() {
		init();
		do {
			ResultController resultController = new ResultController();
			resultController.setResult(inputPlayerNumber());
			OutputView.printGameResult();
			if (resultController.isGameCompleted()) {
				OutputView.printGameComplete();
				gameComplete();
			}
		} while (gameState == GameState.PLAY);
	}

	public void gameComplete() {
		gameState = GameState.COMPLETE;
		askRestart();
	}

	public void askRestart() {
		String playerInput = InputView.inputRestart();
		InputValidator inputValidator = new InputValidator();
		if (!inputValidator.validatePlayerInput(playerInput)) {
			throw new IllegalArgumentException();
		}

		if (playerInput.equals(InputView.GAME_RESTART_INPUT)) {
			restartGame();
		} else if (playerInput.equals(InputView.GAME_EXIT_INPUT)) {
			exitGame();
		}
	}

	private void restartGame() {
		init();
	}

	private void exitGame() {
		gameState = GameState.EXIT;
	}
}
