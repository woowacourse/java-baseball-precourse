package baseball;

public class View {

	public static void input() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public static void hint(Hint hint) {
		String hintResult = "";
		int strike = hint.strike();
		int ball = hint.ball();
		int nothing = hint.nothing();
		if (nothing == Balls.SIZE) {
			System.out.println("낫싱");
			return;
		}
		if (ball != 0) {
			hintResult += ball + "볼 ";
		}
		if (strike != 0) {
			hintResult += strike + "스트라이크";
		}
		System.out.println(hintResult);
	}

	public static void success() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
			+ "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}