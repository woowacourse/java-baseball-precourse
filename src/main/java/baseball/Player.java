package baseball;

import java.util.HashSet;
import java.util.Set;

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
		if (input.length() != 3) {
			throw new IllegalArgumentException("입력된 숫자는 3자리여야 합니다.");
		}
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				throw new IllegalArgumentException("입력은 반드시 숫자여야 합니다.");
			}
		}
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '0') {
				throw new IllegalArgumentException("숫자는 0일 수 없습니다.");
			}
		}
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			set.add(input.charAt(i));
		}
		if (set.size() != 3) {
			throw new IllegalArgumentException("숫자가 중복될 수 없습니다.");
		}
		return input;
	}
}
