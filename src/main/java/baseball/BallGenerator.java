package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BallGenerator {
	private static int START_NUMBER = 1;
	private static int END_NUMBER = 9;

	public List<Integer> createRandomBalls() {
		List<Integer> balls = new ArrayList<>();
		while (balls.size() < 3) {
			int ball = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
			if (!balls.contains(ball)) {
				balls.add(ball);
			}
		}
		return balls;
	}
}
