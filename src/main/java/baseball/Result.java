package baseball;

import java.util.List;
import java.util.Objects;

public class Result {
	int strike;
	int ball;

	public void matchAnswer(List<Integer> answer, List<Integer> gameReply) {
		strike = 0;
		ball = 0;

		for (int idx = 0; idx < 3; idx++) {
			if (Objects.equals(answer.get(idx), gameReply.get(idx))) {
				strike += 1;
				continue;
			}
			if (answer.contains(gameReply.get(idx))) {
				ball += 1;
			}
		}
	}
}
