package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	private Player() {
	}

	public static boolean wantRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String input = Console.readLine();
		if (input.equals("1")) {
			return true;
		}
		if (input.equals("2")) {
			return false;
		}
		throw new IllegalArgumentException("입력은 1 혹은 2 여야 합니다.");
	}
}
