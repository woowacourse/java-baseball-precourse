package baseball;

import java.util.LinkedList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Answer {

	List<Integer> answer;

	public Answer() {
		this.makeAnswer();
	}

	public List<Integer> getAnswer() {
		return answer;
	}

	public void makeAnswer() {
		List<Integer> answer = new LinkedList<>();
		while (answer.size() < 3) {
			int number = Randoms.pickNumberInRange(1, 9);
			if (!answer.contains(number)) {
				answer.add(number);
			}
		}
		this.answer = answer;
	}
}
