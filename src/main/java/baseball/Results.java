package baseball;

import java.util.List;

import baseball.number.Numbers;
import baseball.type.Answer;
import baseball.type.Hint;

public class Results {
	private final List<Hint> hints;
	private final Answer answer;

	private Results(List<Hint> hints, Answer answer) {
		this.hints = hints;
		this.answer = answer;
	}
}
