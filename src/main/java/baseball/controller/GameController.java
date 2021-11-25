package baseball.controller;

import baseball.generator.HintGenerator;
import baseball.generator.RandomNumberGenerator;
import baseball.handler.InputExceptionHandler;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;

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
		String inputNumber;
		ArrayList<Integer> answerNumber = RandomNumberGenerator.generateRandomNumber();

		while (true) {
			OutputView.askNumber();
			inputNumber = InputView.writeInput();

			if (InputExceptionHandler.checkValidation(inputNumber)) {
				ArrayList<Integer> playerNumber = (stringToArrayList(inputNumber));

				giveHint(answerNumber, playerNumber);
			}
		}
	}

	/**
	 * 유저에게 힌트를 제공하는 함수
	 *
	 * @param answerNumber: ArrayList<Integer>
	 * @param playerNumber: ArrayList<Integer>
	 */
	public static void giveHint(ArrayList<Integer> answerNumber, ArrayList<Integer> playerNumber) {
		int ballCount = HintGenerator.ballCounter(answerNumber, playerNumber);
		int strikeCount = HintGenerator.strikeCounter(answerNumber, playerNumber);

		HintGenerator.controlHint(ballCount, strikeCount);
	}

	/**
	 * String 타입을 ArrayList<Integer> 타입으로 변환하는 함수
	 *
	 * @param str: String
	 * @return arr
	 */
	public static ArrayList<Integer> stringToArrayList(String str) {
		ArrayList<Integer> arr = new ArrayList<>(str.length());

		while (arr.size() != str.length()) {
			arr.add(Integer.parseInt(str.split("")[arr.size()]));
		}
		return arr;
	}

}
