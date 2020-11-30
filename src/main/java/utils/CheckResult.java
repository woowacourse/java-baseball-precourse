package utils;

/**
 * 입력된 값을 난수와 비교하여 결과를 내놓는 클래스
 */
public class CheckResult {

	private static final int TRUE_SIZE = 3;

	private final String randomNum;
	private final String inputNum;
	private int strike;
	private int ball;

	public CheckResult(String inputNum, String randomNum) {
		this.inputNum = inputNum;
		this.randomNum = randomNum;
		strike = 0;
		ball = 0;
	}

	public boolean correctNumbers() {
		for (int i = 0; i < TRUE_SIZE; i++) {
			countStrike(i);
		}
		return showResult();
	}

	private void countStrike(int i) {
		if (inputNum.charAt(i) == randomNum.charAt(i)) {
			strike++;
		} else {
			countBall(i);
		}
	}

	private void countBall(int i) {
		if (randomNum.contains(String.valueOf(inputNum.charAt(i)))) {
			ball++;
		}
	}

	private boolean showResult() {
		if (strike == 0 && ball == 0) {
			System.out.println("낫싱");
		} else if (strike == 0) {
			System.out.printf("%d볼\n", ball);
		} else if (ball == 0) {
			System.out.printf("%d스트라이크\n", strike);
		} else {
			System.out.printf("%d볼 %d스트라이크\n", ball, strike);
		}
		if (strike == TRUE_SIZE) {
			System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
			return true;
		}
		return false;
	}

}
