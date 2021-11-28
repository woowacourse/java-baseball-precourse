package baseball.controller;

import java.util.List;

import baseball.domain.Computer;
import baseball.domain.NumberBaseballGame;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseballGameController {

	public void run() {
		Computer computer = new Computer();
		Player player = new Player();
		NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
		repeatGame(numberBaseballGame, player, computer);
	}

	private void repeatGame(NumberBaseballGame numberBaseballGame, Player player, Computer computer) {
		do {
			startGameOnce(numberBaseballGame, player, computer);
			morePlayGame(numberBaseballGame, player);
		} while (player.getSelectPlayMoreGame());
	}

	private void startGameOnce(NumberBaseballGame numberBaseballGame, Player player, Computer computer) {
		settingGame(numberBaseballGame, computer);
		do {
			play(numberBaseballGame, player, computer);
		} while (numberBaseballGame.getGameState());
	}

	private void settingGame(NumberBaseballGame numberBaseballGame, Computer computer) {
		numberBaseballGame.startGame();
		computer.createRandomNumbers();
	}

	private void play(NumberBaseballGame numberBaseballGame, Player player, Computer computer) {
		int[] answer = input(numberBaseballGame, player);
		int strikeCounts = computer.getStrikeCounts(answer);
		int ballCounts = computer.getBallCounts(answer);
		OutputView.hintMessage(ballCounts, strikeCounts);
		changeGameState(numberBaseballGame, computer);
	}

	private int[] input(NumberBaseballGame numberBaseballGame, Player player) {
		List<Integer> inputResult = InputView.getAnswerNumbers();
		numberBaseballGame.validateInputNumber(inputResult);
		return player.receiveAnswerNumbers(inputResult);
	}

	private void changeGameState(NumberBaseballGame numberBaseballGame, Computer computer) {
		if (computer.isCorrect() == Boolean.TRUE) {
			numberBaseballGame.closeGame();
			OutputView.successMessage();
		}
	}

	private void morePlayGame(NumberBaseballGame numberBaseballGame, Player player) {
		String inputResultOfSelectPlayMoreGame = InputView.requestSelectPlayMoreGame();
		Boolean selectPlayMoreGame = numberBaseballGame.validateSelectPlayMoreGame(inputResultOfSelectPlayMoreGame);
		player.receiveSelectPlayMoreGame(selectPlayMoreGame);
	}
}
