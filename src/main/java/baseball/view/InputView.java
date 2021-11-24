package baseball.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 유저에게 입력을 받는 뷰 클래스
 */
public class InputView {

	private static String askNumberMessage = "숫자를 입력해주세요 : ";

	/**
	 * 숫자 입력을 요구하는 메시지를 출력하는 함수
	 */
	public static void askNumber() {
		System.out.print(askNumberMessage);
	}

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
