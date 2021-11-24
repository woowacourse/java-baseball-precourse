package baseball.controller;

import baseball.handler.InputExceptionHandler;
import baseball.view.InputView;

/**
 * 숫자 야구 게임 진행을 제어하는 클래스
 */
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
		if (InputExceptionHandler.checkValidation(playerNumber)) {
			// execute function that prints out about hints in the class of OutputView
		}
	}

}
