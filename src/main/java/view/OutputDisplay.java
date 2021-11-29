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
}
