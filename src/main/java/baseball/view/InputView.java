package baseball.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 유저에게 입력을 받는 뷰 클래스
 */
public class InputView {

	/**
	 * 유저가 숫자를 입력하는 함수
	 *
	 * @return playerNum
	 */
	public static String writeInput() {
		String playerNum;

		playerNum = Console.readLine();
		return playerNum;
	}
}
