package baseball.controller;

import baseball.generator.HintGenerator;
import baseball.generator.RandomNumberGenerator;
import baseball.handler.InputExceptionHandler;
import baseball.handler.TerminateHandler;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;

/**
 * 숫자 야구 게임 진행을 제어하는 클래스
 */
public class GameController {

	private static final int NUMBER_SIZE = 3;
	private static ArrayList<Integer> ANSWER_NUMBER = new ArrayList<>(NUMBER_SIZE);
	private static ArrayList<Integer> PLAYER_NUMBER = new ArrayList<>(NUMBER_SIZE);

	/**
	 * 게임을 제어하는 함수
	 */
	public static void controlGame() {
		RandomNumberGenerator.initProgramNumber(ANSWER_NUMBER);
		ANSWER_NUMBER = RandomNumberGenerator.generateRandomNumber();

		while (true) {
			startGame();
			giveHint(ANSWER_NUMBER, PLAYER_NUMBER);
			if (finishGame(ANSWER_NUMBER, PLAYER_NUMBER)) {
				OutputView.askReplay();
				if (TerminateHandler.decideReplay()) {
					controlGame();
				}
				break;
			}
		}
	}

	/**
	 * 게임을 시작하는 함수
	 */
	public static void startGame() {
		OutputView.askNumber();
		String inputNumber = InputView.writeInput();
		InputExceptionHandler.checkValidation(inputNumber);
		PLAYER_NUMBER = stringToArrayList(inputNumber);
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

	/**
	 * 게임을 종료하는 함수
	 *
	 * @param answerNumber: ArrayList<Integer>
	 * @param playerNumber: ArrayList<Integer>
	 * @return true or false
	 */
	public static boolean finishGame(ArrayList<Integer> answerNumber,
		ArrayList<Integer> playerNumber) {
		if (TerminateHandler.correctAnswer(answerNumber, playerNumber)) {
			OutputView.printCorrectAnswer();
			return true;
		}
		return false;
	}
}