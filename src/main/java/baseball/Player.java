package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	private Player() {
	}

	public static boolean wantRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int input = Integer.parseInt(Console.readLine());
		RestartDecision decision = RestartDecision.from(input);
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
