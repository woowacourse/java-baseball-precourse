package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		do {
			BaseballSystem system = new BaseballSystem();
			system.startOneGameSet();
		} while (!exit());
	}

	private static boolean exit() throws IllegalArgumentException {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String exitNum = Console.readLine();
		if (exitNum.equals(Constant.RESTART)) {
			return false;
		}
		if (exitNum.equals(Constant.QUIT)) {
			return true;
		}
		throw new IllegalArgumentException("1이나 2를 입력해주세요!");
	}
}
