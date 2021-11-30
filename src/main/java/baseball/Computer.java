package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private List<Integer> answerNumber;

	public Computer() {
		this.answerNumber = generateAnswer();
	}

	public List<Integer> getAnswerNumber() {
		return answerNumber;
	}

	private List<Integer> generateAnswer() {
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < Const.ANSWER_SIZE; i++) {
			insertUniqueNumber(answer);
		}

		return answer;
	}

	private void insertUniqueNumber(List<Integer> answer) {
		int r = Randoms.pickNumberInRange(Const.MIN_ANSWER_VALUE, Const.MAX_ANSWER_VALUE);

		if (!answer.contains(r)) {
			answer.add(r);
			return;
		}

		insertUniqueNumber(answer);
	}
}
