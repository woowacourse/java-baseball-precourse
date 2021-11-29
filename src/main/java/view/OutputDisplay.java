package view;

public class OutputDisplay {

	private OutputDisplay() {
	}

	public static void pleaseInputNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public static void showBallCount(int ballCount) {
		System.out.print(ballCount + "볼 ");
	}

	public static void showStrikeCount(int strikeCount) {
		System.out.print(strikeCount + "스트라이크");
	}

	public static void showNothing() {
		System.out.print("낫싱");
	}

	public static void enterBlank() {
		System.out.println();
	}

	public static void chooseNextGame(int strikeCount) {
		System.out.println(strikeCount + "스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
