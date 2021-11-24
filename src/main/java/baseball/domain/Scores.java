package baseball.domain;

import java.util.List;

public class Scores {
	private final List<Score> scores;

	private Scores(List<Score> scores) {
		this.scores = scores;
	}

	public static Scores of(List<Score> scores) {
		return new Scores(scores);
	}

	public int getStrikeCount() {
		return (int)scores.stream().filter(Score::isStrike).count();
	}

	public int getBallCount() {
		return (int)scores.stream().filter(Score::isBall).count();
	}
}
