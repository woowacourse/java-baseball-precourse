package baseball.domain;

import java.util.List;

public class Result {
	private final List<Scores> result;

	private Result(List<Scores> result) {
		this.result = result;
	}

	public static Result of(List<Scores> result) {
		return new Result(result);
	}

	public int getStrikeCount() {
		return result.stream().mapToInt(Scores::getStrikeCount).sum();
	}

	public int getBallCount() {
		return result.stream().mapToInt(Scores::getBallCount).sum();
	}
}
