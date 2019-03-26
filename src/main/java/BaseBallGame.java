/*
 * BaseBallGame.java
 */

/**
 * 숫자 야구 게임을 진행하는 클래스
 */
public class BaseBallGame {

	private String randomNumber;
	private int strike;
	private int ball;

	/**
	 * strike, ball 수를 초기화
	 * @param
	 */
	public BaseBallGame(String randomNumber) {
		this.randomNumber = randomNumber;
		strike = 0;
		ball = 0;
	}

	/**
	 * BaseBallGame 객체의 randomNumber값 변경
	 * @param randomNumber
	 */
	public void setRandomNumber(String randomNumber) {
		this.randomNumber = randomNumber;
	}

	private void answerCheck(String inputString) {
		for (int i = 0; i < inputString.length(); i++) {
			char curChar = inputString.charAt(i);

			if (curChar == randomNumber.charAt(i)) {
				strike++;
			} else if (randomNumber.contains(Character.toString(curChar))) {
				ball++;
			}
		}
	}

	public void printResult(String inputString) {

		answerCheck(inputString);

		StringBuilder res = new StringBuilder();
		if (strike > 0) {
			res.append(strike);
			res.append(" 스트라이크 ");
		}
		if (ball > 0) {
			res.append(ball);
			res.append("볼");
		}
		if ((strike == 0) && (ball == 0)) {
			res.append("낫싱");
		}

		System.out.println(res);
	}

	public boolean isCorrect() {
		if (strike == 3) {
			//System.out.println("난수: " + randomNumber);
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료!");
			return true;
		} else {
			this.strike = 0;
			this.ball = 0;
			return false;
		}
	}
}
