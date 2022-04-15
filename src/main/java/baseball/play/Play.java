package baseball.play;

import baseball.model.Computer;
import baseball.model.User;

public class Play {
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String STRIKE_AND_BALL_MESSAGE = "%s볼 %s스트라이크";
	private static final String ONLY_STRIKE_MESSAGE = "%s스트라이크";
	private static final String ONLY_BALL_MESSAGE = "%s볼";
	private static final String ALL_STRIKE_MESSAGE = "3스트라이크";

	public static boolean playBall(String computerNumber, User user) {
		int strike = 0;
		int ball = 0;
		for(int i = 0; i < user.getNumbers().length; i++) {
			String userNumber = user.getNumbers()[i];
			if (computerNumber.indexOf(userNumber) == -1) {
				continue;
			}
			if (computerNumber.indexOf(userNumber) == i) {
				strike ++;
				continue;
			}
			if (computerNumber.indexOf(userNumber) != i) {
				ball ++;
				continue;
			}
		}

		return result(strike, ball);
	}
	
	public static boolean result(int strike, int ball) {

		if (strike == 3) {
			System.out.println(ALL_STRIKE_MESSAGE);
			return true;
		}
        if (strike == 0 && ball == 0) {
			System.out.println(NOTHING_MESSAGE);
			return false;
        }

        if (strike > 0 && ball == 0) {
			System.out.println(String.format(ONLY_STRIKE_MESSAGE, strike));
			return false;
        }

        if (strike == 0 && ball > 0) {
			System.out.println(String.format(ONLY_BALL_MESSAGE, ball));
			return false;
        }

		if (strike > 0 && ball > 0) {
			System.out.println(String.format(STRIKE_AND_BALL_MESSAGE, ball, strike));
			return false;
		}

		return true;
	}
	
	
}
