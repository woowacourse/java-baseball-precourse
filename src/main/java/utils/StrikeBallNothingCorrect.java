package utils;

/**
 * 입력된 값을 난수와 비교하여 결과를 내놓는 클래스
 */
public class StrikeBallNothingCorrect {

	private static int TRUE_SIZE = 3;

	private String randomNum;
	private String inputNum;
	private int strike;
	private int ball;

	public StrikeBallNothingCorrect(String inputNum, String randomNum) {
		this.inputNum = inputNum;
		this.randomNum = randomNum;
		strike = 0;
		ball = 0;
	}

	/**
	 * 입력값이 난수를 비교하여 같으면 true를 반환한다.
	 * @return boolean
	 */
	public boolean correctingNumbers() {
		for (int i = 0; i < TRUE_SIZE; i++) {
			countStrike(i);
		}
		return showResult();
	}

	/**
	 * 스트라이크일 경우 스트라이크 수를 더한다. 스트라이크가 아닐 경우 볼인지 검사한다.
	 * @param i
	 */
	private void countStrike(int i) {
		if (inputNum.charAt(i) == randomNum.charAt(i)) {
			strike++;
		} else {
			countBall(i);
		}
	}

	/**
	 * 볼일 경우 볼 수를 더한다.
	 * @param i
	 */
	private void countBall(int i) {
		if (randomNum.contains(String.valueOf(inputNum.charAt(i)))) {
			ball++;
		}
	}

	/**
	 * 결과값을 출력하고 모두 맞혔을 경우 true를 반환한다.
	 * @return boolean
	 */
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
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}

}
