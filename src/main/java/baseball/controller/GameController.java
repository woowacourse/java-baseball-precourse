package baseball.controller;

import baseball.view.InputView;

public class GameController {

	/**
	 * 게임을 제어하는 함수
	 */
	public static void controlGame() {
		startGame();
	}

	/**
	 * 게임을 시작하는 함수
	 */
	public static void startGame() {
		String playerNumber;

		InputView.askNumber();
		playerNumber = InputView.writeInput();
		System.out.println(playerNumber);
	}

}
