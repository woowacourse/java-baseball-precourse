package baseball.controller;

import java.util.List;

import baseball.domain.Computer;
import baseball.domain.NumberBaseballGame;
import baseball.domain.Player;
import baseball.view.InputView;

public class NumberBaseballGameController {

	public static void run() {
		Computer computer = new Computer();
		Player player = new Player();
		NumberBaseballGame numberBaseballGame = new NumberBaseballGame();

		computer.createRandomNumbers();
		play(numberBaseballGame, player);
	}

	private static void play(NumberBaseballGame numberBaseballGame, Player player) {
		try {
			input(numberBaseballGame, player);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}

	private static int[] input(NumberBaseballGame numberBaseballGame, Player player) {
		List<Integer> inputResult = InputView.getAnswerNumbers();
		numberBaseballGame.validateInputNumber(inputResult);
		return player.receiveAnswerNumbers(inputResult);
	}
}
