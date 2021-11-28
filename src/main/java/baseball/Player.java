package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	private Player() {
	}

	public static boolean wantRestart() {
		RestartDecision decision = GameInput.readRestartDecision();
		return decision.isRestart();
	}

	public static String predictBalls() {
		System.out.print("숫자를 입력해주세요 : ");
		String input = Console.readLine();
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				throw new IllegalArgumentException("입력은 반드시 숫자여야 합니다.");
			}
		}
		return input;
	}
}
