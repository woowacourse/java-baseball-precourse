package baseball;

import java.util.LinkedList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

// 숫자 야구의 정답 클래스
public class Answer {

	private List<Integer> answer;

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
