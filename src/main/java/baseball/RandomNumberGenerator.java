package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
	private static final int MAX_LENGTH = 3;

	public List<Integer> generate() {
		List<Integer> answer = new ArrayList<>();
		while (answer.size() < MAX_LENGTH) {
			addNotDuplicatedNumber(answer);
		}
		return answer;
	}

	private void addNotDuplicatedNumber(List<Integer> answer) {
		int number = Randoms.pickNumberInRange(1, 9);
		if (!answer.contains(number)) {
			answer.add(number);
		}
		return;
	}
}
