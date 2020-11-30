package utils;

/**
 * 입력된 값을 난수와 비교하여 결과를 내놓는 클래스
 */
public class CheckResult {

	private static final int TRUE_SIZE = 3;

	private final String NOTHING = "낫싱";
	private final String ONLY_BALL = "%d볼\n";
	private final String ONLY_STRIKE = "%d스트라이크\n";
	private final String BALL_AND_STRIKE = "%d볼 %d스트라이크\n";
	private final String CORRECT_ANSWER = "3개의 숫자를 모두 맞추셨습니다! 게임 종료.\n" +
			"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	private final String random;
	private final String input;
	private int strike;
	private int ball;

	public CheckResult(String input, String random) {
		this.input = input;
		this.random = random;
		strike = 0;
		ball = 0;
	}

	public boolean correctNumbers() {
		for (int i = 0; i < TRUE_SIZE; i++) {
			countStrike(i);
		}
		return showResult();
	}

	private void countStrike(int index) {
		if (input.charAt(index) == random.charAt(index)) {
			strike++;
		} else {
			countBall(index);
		}
	}

	private void countBall(int index) {
		if (random.contains(String.valueOf(input.charAt(index)))) {
			ball++;
		}
	}

	private boolean showResult() {
		if (strike == 0 && ball == 0) {
			System.out.println(NOTHING);
		} else if (strike == 0) {
			System.out.printf(ONLY_BALL, ball);
		} else if (ball == 0) {
			System.out.printf(ONLY_STRIKE, strike);
		} else {
			System.out.printf(BALL_AND_STRIKE, ball, strike);
		}
		if (strike == TRUE_SIZE) {
			System.out.println(CORRECT_ANSWER);
			return true;
		}
		return false;
	}

}
