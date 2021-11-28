package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

	private List<Ball> balls;

	public Balls(List<Ball> balls) {
		checkSize(balls);
		checkDuplicated(balls);
		this.balls = balls;
	}

	private void checkSize(List<Ball> balls) {
		if (balls.size() != 3) {
			throw new IllegalArgumentException("입력된 Ball은 3개여야 합니다");
		}
	}

	private void checkDuplicated(List<Ball> balls) {
		Set<Ball> set = new HashSet<>(balls);
		if (set.size() != 3) {
			throw new IllegalArgumentException("Ball의 숫자는 중복될 수 없습니다");
		}
	}
}
