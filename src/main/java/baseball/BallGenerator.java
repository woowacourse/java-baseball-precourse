package baseball;

import static baseball.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;

public class BallGenerator {
	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 9;

	public String createRandomBalls() {
		StringBuilder balls = new StringBuilder();
		while (balls.length() < MAX_LENGTH) {
			String ball = String.valueOf(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
			if (!balls.toString().contains(ball)) {
				balls.append(ball);
			}
		}
		return balls.toString();
	}
}
