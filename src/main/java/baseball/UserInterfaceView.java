package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

public class UserInterfaceView {
	private static final String NUMBER_INPUT = "숫자를 입력해주세요 : ";
	private static final String THREE_STRIKE_GAME_OVER = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String IS_BALL = "볼 ";
	private static final String IS_STRIKE = "스트라이크";
	private static final String IS_NOTHING = "낫싱";
	private static final String GAME_RESTART_OR_NOT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String NUMBER_LENGTH_ERROR_MESSAGE = "잘못된 길이의 숫자를 입력했습니다.";
	private static final String NUMBER_OVERLAP_ERROR_MESSAGE = "동일한 숫자를 입력했습니다.";

	public static void printNumberInputMessage() {
		System.out.print(NUMBER_INPUT);
	}

	public static ArrayList<Integer> inputUserNumbers() {
		int[] tempInput = Stream.of(Console.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		if (!isValidNumberLength(tempInput)) {
			throw new IllegalArgumentException(NUMBER_LENGTH_ERROR_MESSAGE);
		}
		ArrayList<Integer> userInputNumbers = new ArrayList<>();
		for (int i : tempInput) {
			Integer number = new Integer(i);
			userInputNumbers.add(number);
		}
		if (!isValidNumberOverlap(userInputNumbers)) {
			throw new IllegalArgumentException(NUMBER_OVERLAP_ERROR_MESSAGE);
		}
		return userInputNumbers;

	}

	public static boolean isValidNumberOverlap(ArrayList<Integer> userInputNumbers) {
		for (Integer i : userInputNumbers) {
			if (Collections.frequency(userInputNumbers, i) > 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidNumberLength(int[] tempInput) {
		if (tempInput.length != RandomNumber.PICK_NUMBER) {
			return false;
		}
		return true;
	}

	public static void printBallAndStrikeCount(int ball, int strike) {
		String hint = "";
		if (ball == 0 && strike == 0) {
			System.out.println(IS_NOTHING);
			return;
		}
		if (ball != 0) {
			hint += (ball + IS_BALL);
		}
		if (strike != 0) {
			hint += (strike + IS_STRIKE);
		}
		if (strike == RandomNumber.PICK_NUMBER) {
			hint += THREE_STRIKE_GAME_OVER;
		}
		System.out.println(hint);
	}

	public static void printGameRestartMessage() {
		System.out.println(GAME_RESTART_OR_NOT);
	}

	public static int inputGameRestartOrNot() {
		String inputGameRestart = Console.readLine();
		return Integer.parseInt(inputGameRestart);
	}
}
