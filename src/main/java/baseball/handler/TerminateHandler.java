package baseball.handler;

import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.Objects;

/**
 * 프로그램 종료에 대한 처리를 하는 클래스
 */
public class TerminateHandler {

	/**
	 * 정답을 맞췄는지 확인하는 함수
	 *
	 * @param answerNumber: ArrayList<Integer>
	 * @param playerNumber: ArrayList<Integer>
	 * @return true or false
	 */
	public static boolean correctAnswer(ArrayList<Integer> answerNumber,
		ArrayList<Integer> playerNumber) {
		return answerNumber.equals(playerNumber);
	}

	/**
	 * 게임 재시작을 결정하는 함수
	 *
	 * @return true or false
	 */
	public static boolean decideReplay() {
		String number = InputView.writeReplayOrNot();
		return (Objects.equals(number, "1"));
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
