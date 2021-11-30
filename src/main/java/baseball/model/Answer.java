package baseball.model;

import java.util.List;

public class Answer {
	private List<Integer> answer;

	public Answer(List<Integer> answer) {
		this.answer = answer;
	}

	public boolean contains(int number) {
		return answer.contains(number);
	}

	public int indexOf(int number) {
		return answer.indexOf(number);
	}
}
