package view;

import java.util.Scanner;

import domain.BaseballGameStatus;
import domain.BaseballNumbers;

public class InputView {
	private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요";
	private static final String INPUT_ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
	private static final Scanner SCANNER = new Scanner(System.in);

	public static BaseballNumbers getBaseballNumbers() {
		try {
			System.out.println(INPUT_NUMBER_MESSAGE);
			return new BaseballNumbers(SCANNER.nextLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getBaseballNumbers();
		}
	}

	public static BaseballGameStatus getGameStatus() {
		try {
			System.out.println(INPUT_ASK_RESTART_MESSAGE);
			return BaseballGameStatus.get(SCANNER.nextLine());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
			return getGameStatus();
		}
	}

}
