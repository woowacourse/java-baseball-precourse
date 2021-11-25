package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application extends IllegalArgumentException {
	public static void main(String[] args) {
		do {
			BaseballSystem system = new BaseballSystem();
			system.gameStart();
		} while (!exit());
	}

	public static boolean exit() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String exitNum = Console.readLine();
		if (exitNum.equals("1")) {
			return false;
		}
		if (exitNum.equals("2")) {
			return true;
		}
		throw new IllegalArgumentException();
	}
}
