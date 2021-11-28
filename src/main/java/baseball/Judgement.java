package baseball;

import java.util.List;

public class Judgement {
	public PlayResult play(List<Integer> computer, List<Integer> player) {
		PlayResult playResult = new PlayResult();
		for (int position = 0; position < player.size(); position++) {
			playResult.report(play(computer, position, player.get(position)));
		}
		return playResult;
	}

	private BallStatus play(List<Integer> computer, int position, int playerBall) {
		if (computer.get(position) == playerBall) {
			return BallStatus.STRIKE;
		} else if (computer.contains(playerBall)) {
			return BallStatus.BALL;
		}
		return BallStatus.NOTHING;
	}
}
