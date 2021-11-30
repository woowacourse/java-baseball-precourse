package baseball;

import java.util.ArrayList;
import java.util.List;

import baseball.number.Number;
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

	public static Results of(Numbers computer, Numbers player){
		List<Number> numbers = player.getNumbers();
		List<Hint> hints = new ArrayList<>();
		for(int i = 0;i< numbers.size();i++){
			Hint hint = computer.getHint(numbers.get(i), i);
			hints.add(hint);
		}
		Answer answer = getAnswer(hints);
		return new Results(hints,answer);
	}
	
	private static Answer getAnswer(List<Hint> hints){
		long strikeNum = hints.stream()
			.filter(Hint::isStrike)
			.count();
		if(strikeNum==3){
			return Answer.CORRECT;
		}
		return Answer.INCORRECT;
	}
}
