package baseball;


public class BaseballGame {
	
	private static final int BALL_CHECK_NUMBER = 3;
	private static final int STRIKE_CHECK_NUMBER = 3;
	
	public BaseballGame(){
		//BaseballGameUtils.makeThreeLengthRandomNumber();
		//int number = BaseballGameUtils.getNumberFromUser();
	}
	
	public void checkScore() {
		int countBalls = 0;
		int countStrikes = 0;
		countBalls = checkBall();
		countStrikes = checkStrike();
		
		if (countBalls + countStrikes == 0) {
			System.out.println("낫싱");
		}
		if (countBalls != 0) {
			System.out.println(countBalls+"볼");
		}
		if (countStrikes > 0 && countStrikes <= STRIKE_CHECK_NUMBER) {
			System.out.println(countStrikes+"스트라이크");
		}
		if (countStrikes == STRIKE_CHECK_NUMBER) {
			System.out.println(STRIKE_CHECK_NUMBER+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
	}
	
	private int checkBall() {
		int number = 0;
		return number;
	}
	
	private int checkStrike() {
		int number = 0;
		return number;
	}

}
