package baseball.handler;

import java.util.ArrayList;

/**
 * 프로그램 종료에 대한 처리를 하는 클래스
 */
public class TerminateHandler {

	/** 정답을 맞췄는지 확인하는 함수
	 *
	 * @param answerNumber: ArrayList<Integer>
	 * @param playerNumber: ArrayList<Integer>
	 * @return true or false
	 */
	public static boolean correctAnswer(ArrayList<Integer> answerNumber, ArrayList<Integer> playerNumber) {
		return answerNumber.equals(playerNumber);
	}
}
