package baseball.domain;

import java.util.List;

public class Scores {
	private final List<Score> scores;

	private Scores(List<Score> scores) {
		this.scores = scores;
	}

	public static Scores from(List<Score> scores) {
		return new Scores(scores);
	}

	public int getStrikeCount() {
		return (int)scores.stream().filter(Score::isStrike).count();
	}

	public int getBallCount() {
		return (int)scores.stream().filter(Score::isBall).count();
	}

	public boolean hasStrike() {
		return scores.stream().anyMatch(Score::isStrike);
	}

	public boolean hasBall() {
		return scores.stream().anyMatch(Score::isBall);
	}
}
