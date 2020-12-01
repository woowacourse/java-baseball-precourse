package utils;

import domain.Computer;
import domain.User;

public class BallStrikeCheckUtils {
	private static final Integer MAX_BALL_CNT = 3;
	private static final Integer ZERO = 0;

	private static Computer computer = Computer.getInstance();
	private static User user = User.getInstance();

	public static int getBall() {
		int ball = ZERO;
		
		for (int idx = ZERO; idx < MAX_BALL_CNT; idx++) {
			if (computer.getNumber(idx) == user.getNumber(idx)) {
				continue;
			}
			if (computer.getNumbers().contains(user.getNumber(idx))) {
				ball++;
			}
		}
		
		return ball;
	}

	public static int getStrike() {
		int strike = ZERO;
		
		for (int idx = ZERO; idx < MAX_BALL_CNT; idx++) {
			if (computer.getNumber(idx) == user.getNumber(idx)) {
				strike++;
			}
		}
		
		return strike;
	}
}
