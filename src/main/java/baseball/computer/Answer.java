package baseball.computer;

import java.util.LinkedList;
import java.util.List;

import static baseball.util.ConstantUtil.*;

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
		while (answer.size() < ANSWER_SIZE) {
			int number = getRandomNumber();
			if (!answer.contains(number)) {
				answer.add(number);
			}
		}
		this.answer = answer;
	}

	public int getRandomNumber() {
		return Randoms.pickNumberInRange(ANSWER_MIN, ANSWER_MAX);
	}
}
