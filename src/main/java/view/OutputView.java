package view;

import domain.Hint;

public class OutputView {
	private static final String INPUT_INSTRUCTION = "숫자를 입력해주세요 : ";
	private static final String BALL = "볼";
	private static final String STRIKE = "스트라이크";
	private static final String CONGRATULATIONS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static void printInstruction() {
		System.out.print(OutputView.INPUT_INSTRUCTION);
	}

	public static void printHint(Hint hint) {
		int ballCount = hint.getBall(), strikeCount = hint.getStrike();

		if (ballCount > 0) {
			System.out.print(ballCount + BALL + " ");
		}

		if (strikeCount > 0) {
			System.out.print(strikeCount + STRIKE);
		}

		System.out.println();

		if (strikeCount == 3) {
			System.out.println(CONGRATULATIONS_MESSAGE);
		}
	}
}
