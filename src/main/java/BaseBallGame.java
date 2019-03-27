/*
 * BaseBallGame.java    1.00  2019/03/27
 *
 * copyright by yuyu154
 * All rights reserved.
 */

/**
 * 숫자 야구 게임을 진행을 담당하는 클래스
 */
public class BaseBallGame {

	/** 3자리의 랜덤 숫자를 저장할 문자열 */
	private String randomNumber;

	/** 입력 문자열에 대한 strike 수를 저장할 int 변수 */
	private int strike;

	/** 입력 문자열에 대한 ball 수를 저장할 int 변수 */
	private int ball;

	/**
	 * randomNumber, strike, ball 초기화
	 * @param randomNumber
	 */
	public BaseBallGame(String randomNumber) {
		this.randomNumber = randomNumber;
		this.strike = 0;
		this.ball = 0;
	}

	/**
	 * 입력 문자열과 randomNumber 을 비교해 strike, ball 설정
	 * @param inputString 입력 문자열
	 */
	private void answerCheck(String inputString) {
		char curChar;
		for (int i = 0; i < inputString.length(); i++) {
			curChar = inputString.charAt(i);

			if (curChar == randomNumber.charAt(i)) {
				this.strike++;
			} else if (randomNumber.contains(Character.toString(curChar))) {
				this.ball++;
			}
		}
	}

	/**
	 * strike, ball 값에 따라 게임 결과 출력
	 * @param inputString 입력 문자열
	 */
	public void printResult(String inputString) {
		StringBuilder res = new StringBuilder();

		answerCheck(inputString);
		if (this.strike > 0) {
			res.append(strike);
			res.append(" 스트라이크 ");
		}
		if (this.ball > 0) {
			res.append(ball);
			res.append("볼");
		}
		if ((this.strike == 0) && (this.ball == 0)) {
			res.append("낫싱");
		}

		System.out.println(res);
	}

	/**
	 * strike 이 3인지 검사하는 함수
	 * @return strike 수가 3이면 true 반환
	 */
	public boolean isCorrect() {
		if (this.strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료!");
			return true;
		} else {
			this.strike = 0;
			this.ball = 0;
			return false;
		}
	}
}
