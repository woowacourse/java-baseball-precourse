package baseball;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

public class View {
	private static final String NUMBER_INPUT = "숫자를 입력해주세요 : ";
	private static final String THREE_STRIKE_GAME_OVER = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String IS_BALL = "볼";
	private static final String IS_STRIKE = "스트라이크";
	private static final String IS_NOTHING = "낫싱";

	public static void printNumberInputMessage() {
		System.out.print(NUMBER_INPUT);
	}

	public static int[] inputUserNumbers() {
		String tempInput = Console.readLine();
		int[] userInputNumbers = Stream.of(tempInput.split("")).mapToInt(Integer::parseInt).toArray();
		System.out.println(Arrays.toString(userInputNumbers));
		return userInputNumbers;
	}

	public static void printHint(HashMap<String, Integer> hintMap) {
		int ball = hintMap.get("ball");
		int strike = hintMap.get("strike");
		if (strike == 3) {
			System.out.println(String.valueOf(strike) + "스트라이크" + THREE_STRIKE_GAME_OVER);
			return;
		}
		if (strike == 0 && ball == 0) {
			System.out.println(IS_NOTHING);
			return;
		}
		if (strike == 0) {
			System.out.println(String.valueOf(ball) + IS_BALL);
			return;
		}
		if (ball == 0) {
			System.out.println(String.valueOf(strike) + IS_STRIKE);
			return;
		}
		System.out.println(String.valueOf(ball) + IS_BALL + " " + String.valueOf(strike) + IS_STRIKE);
	}
}
