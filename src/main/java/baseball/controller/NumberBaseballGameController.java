package baseball.controller;

import java.util.List;

import baseball.domain.Computer;
import baseball.domain.NumberBaseballGame;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseballGameController {

	public static void run() {
		Computer computer = new Computer();
		Player player = new Player();
		NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
		numberBaseballGame.startGame();
		computer.createRandomNumbers();
		do {
			play(numberBaseballGame, player, computer);
		} while (numberBaseballGame.getGameState());
	}

	private static void play(NumberBaseballGame numberBaseballGame, Player player, Computer computer) {
		try {
			int[] answer = input(numberBaseballGame, player);
			int strikeCounts = computer.getStrikeCounts(answer);
			int ballCounts = computer.getBallCounts(answer);
			OutputView.hintMessage(ballCounts, strikeCounts);
			changeGameState(numberBaseballGame, computer);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}

	private static int[] input(NumberBaseballGame numberBaseballGame, Player player) {
		List<Integer> inputResult = InputView.getAnswerNumbers();
		numberBaseballGame.validateInputNumber(inputResult);
		return player.receiveAnswerNumbers(inputResult);
	}

	private static void changeGameState(NumberBaseballGame numberBaseballGame, Computer computer) {
		if (computer.isCorrect() == Boolean.TRUE) {
			numberBaseballGame.closeGame();
			OutputView.successMessage();
		}
	}
}
