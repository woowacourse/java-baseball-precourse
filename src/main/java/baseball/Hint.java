package baseball;

import static baseball.BallType.BALL;
import static baseball.BallType.NOTHING;
import static baseball.BallType.STRIKE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hint {

	private Map<BallType, Integer> hint = new HashMap<>();

	{
		hint.put(STRIKE, 0);
		hint.put(BALL, 0);
		hint.put(NOTHING, 0);
	}

	public Hint(Balls computer, Balls user) {
		compare(computer, user);
	}

	public BallType getType(Balls computer, Ball ball, int position) {
		List<Ball> computerBallList = computer.getList();
		if (computerBallList.get(position)
			.equals(ball)) {
			return STRIKE;
		}
		if (computerBallList.contains(ball)) {
			return BALL;
		}
		return NOTHING;
	}

	public void compare(Balls computer, Balls user) {
		List<Ball> userBallList = user.getList();
		for (int i = 0; i < userBallList.size(); i++) {
			BallType type = getType(computer, userBallList.get(i), i);
			hint.replace(type, hint.get(type) + 1);
		}
	}

	public int strike() {
		return hint.get(STRIKE);
	}

	public int ball() {
		return hint.get(BALL);
	}

	public int nothing() {
		return hint.get(NOTHING);
	}
}