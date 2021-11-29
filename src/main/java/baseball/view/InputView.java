package baseball.view;

import java.util.ArrayList;
import java.util.stream.Stream;

import baseball.Exception;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String NUMBER_INPUT = "숫자를 입력해주세요 : ";
	private static final String GAME_RESTART_OR_NOT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static void printNumberInputMessage() {
		System.out.print(NUMBER_INPUT);
	}

	public static ArrayList<Integer> inputUserNumbers() {
		String input = Console.readLine();
		Exception.validateNumberInput(input);

		int[] tempInput = Stream.of(input.split("")).mapToInt(Integer::parseInt).toArray();
		ArrayList<Integer> userInputNumbers = new ArrayList<>();
		for (int i : tempInput) {
			Integer number = new Integer(i);
			userInputNumbers.add(number);
		}
		return userInputNumbers;
	}

	public static void printGameRestartMessage() {
		System.out.println(GAME_RESTART_OR_NOT);
	}

	public static boolean inputGameRestartOrNot() {
		return Exception.isValidRestartInput(Console.readLine());
	}
}
