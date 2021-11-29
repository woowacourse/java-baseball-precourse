package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
	
	private static final int BALL_CHECK_NUMBER = 3;
	private static final int STRIKE_CHECK_NUMBER = 3;
	boolean threeStrike = false;
	boolean gameRetry = false;
	
	public BaseballGame(){
		while (!gameRetry) {
			String computerNumber = BaseballGameUtils.makeThreeLengthRandomNumber();
			threeStrike = false;
			while (!threeStrike) {
				String userNumber = BaseballGameUtils.getNumberFromUser();
				checkScore(computerNumber, userNumber);
			}
		}
	}
	
	public void checkScore(String computerNumber, String userNumber) { 
		int countBalls = 0;
		int countStrikes = 0;
		countBalls = checkBall(computerNumber, userNumber);
		countStrikes = checkStrike(computerNumber, userNumber);
		if (countBalls + countStrikes == 0) {
			System.out.println("낫싱");
		}
		if (countBalls != 0 && countStrikes != 0) {
			System.out.print(countBalls+"볼 ");
		}
		if (countBalls != 0 && countStrikes == 0) {
			System.out.println(countBalls+"볼");
		}
		if (countStrikes > 0 && countStrikes <= STRIKE_CHECK_NUMBER) {
			System.out.println(countStrikes+"스트라이크");
		}
		if (countStrikes == STRIKE_CHECK_NUMBER) {
			System.out.println(STRIKE_CHECK_NUMBER+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
			threeStrike = true;
			gameRetry = checkRetryGame();
		}
	}
	
	private int checkBall(String computerNumber, String userNumber) {
		int ballCount = 0;
		if ((computerNumber.charAt(0) != userNumber.charAt(0)) 
				&& (computerNumber.charAt(0) == userNumber.charAt(1) || computerNumber.charAt(0) == userNumber.charAt(2))) {
			ballCount++;
		}
		if ((computerNumber.charAt(1) != userNumber.charAt(1))
				&& (computerNumber.charAt(1) == userNumber.charAt(0) || computerNumber.charAt(1) == userNumber.charAt(2))) {
			ballCount++;
		}
		if ((computerNumber.charAt(2) != userNumber.charAt(2))
				&& (computerNumber.charAt(2) == userNumber.charAt(0) || computerNumber.charAt(2) == userNumber.charAt(1))) {
			ballCount++;
		}
		return ballCount;
	}
	
	private int checkStrike(String computerNumber, String userNumber) {
		int strikeCount = 0;
		for (int i = 0; i < computerNumber.length(); i++) {
			if (computerNumber.charAt(i) == userNumber.charAt(i)) {
				strikeCount++;
			}
		}
		return strikeCount;
	}
	
	private boolean checkRetryGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return BaseballGameUtils.getGameEnd(); //false 재시작 true 종료
	}

}
