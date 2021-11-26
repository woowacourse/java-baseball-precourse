package baseball;

import java.util.List;

public class Referee {
	List<Ball> computerBalls;
	private int strikeCount = 0;
	private int ballCount = 0;

	public Referee(List<Ball> balls) {
		this.computerBalls = balls;
	}

	public void judge(List<Ball> balls) {
		for (Ball ball : balls) {
			judgeElement(ball);
		}
	}

	private void judgeElement(Ball ball) {
		for (int i = 0; i < computerBalls.size(); i++) {
			if (ball.getPosition() == i && ball.getNumber() == computerBalls.get(i).getNumber()) {
				strikeCount++;
				return;
			}
			if (ball.getNumber() == computerBalls.get(i).getNumber()) {
				ballCount++;
				return;
			}
		}
	}

	public int getBallCount() {
		return ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public void clearScore() {
		ballCount = 0;
		strikeCount = 0;
	}

	public void setBalls(List<Ball> balls) {
		this.computerBalls = balls;
	}
}
