package utils;

import domain.Computer;
import domain.User;

/**
 * 현재 저장된 숫자 리스트를 비교해 볼과 스트라이크 수를 리턴해주는 util
 * 기능 1. 볼 갯수를 리턴
 * 기능 2. 스트라이크 갯수를 리턴
 */
public class BallStrikeCheckUtils {
	/** 최대로 생성할 수 있는 숫자 갯수를 한정하는 상수 */
	private static final Integer MAX_BALL_CNT = 3;
	
	/** 초기값을 위한 상수 */
	private static final Integer ZERO = 0;

	/** 볼, 스트라이크 갯수를 체크할 두 객체 불러오기 */
	private static Computer computer = Computer.getInstance();
	private static User user = User.getInstance();

	/** 볼 갯수를 리턴하는 메소드 */
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

	/** 스트라이크 갯수를 리턴하는 메소드 */
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
