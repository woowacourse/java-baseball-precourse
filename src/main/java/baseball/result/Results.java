package baseball.result;

import java.util.ArrayList;
import java.util.List;

import baseball.number.Number;
import baseball.number.Numbers;
import baseball.type.Answer;
import baseball.type.Hint;

public class Results {
	private final List<Hint> hints;
	private final Answer answer;

	private Results(List<Hint> hints) {
		this.hints = hints;
		this.answer = getAnswer();
	}

	public static Results of(Numbers computer, Numbers player) {
		List<Number> numbers = player.getNumbers();
		List<Hint> hints = new ArrayList<>();
		for (int i = 0; i < numbers.size(); i++) {
			Hint hint = computer.getHint(numbers.get(i), i);
			hints.add(hint);
		}
		return new Results(hints);
	}

	private Answer getAnswer() {
		long strikeNum = countHint(Hint.STRIKE);
		if (strikeNum == 3) {
			return Answer.CORRECT;
		}
		return Answer.INCORRECT;
	}

	private long countHint(Hint hint) {
		return hints.stream()
			.filter(h -> h == hint)
			.count();
	}

	private boolean isNothing() {
		long count = countHint(Hint.NOTHING);
		return count == 3;
	}

	@Override
	public String toString() {
		if (isNothing()) {
			return Hint.NOTHING.getTag();
		}
		long countStrike = countHint(Hint.STRIKE);
		long countBall = countHint(Hint.BALL);
		if (countStrike == 0) {
			return countBall +Hint.BALL.getTag();
		} else if (countBall == 0) {
			return countStrike +Hint.STRIKE.getTag();
		}
		return countBall +Hint.BALL.getTag() +" " +countStrike +Hint.STRIKE.getTag();
	}

	public boolean isCorrect() {
		return answer.isCorrect();
	}
}
