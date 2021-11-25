package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.type.NumberRangeType;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private static List<Integer> numbers;

	public Computer() {
		this.numbers = new ArrayList<>(NumberRangeType.ANSWER_SIZE.getNumberRange());
	}

	public void generateAnswerNumbers() {
		int pickCount = 0;
		while (pickCount < NumberRangeType.ANSWER_SIZE.getNumberRange()) {
			int pickedNumber = Randoms.pickNumberInRange(NumberRangeType.MIN_NUMBER.getNumberRange(),
				NumberRangeType.MAX_NUMBER.getNumberRange());
			if (!isDuplicate(pickedNumber)) {
				numbers.add(pickedNumber);
				pickCount++;
			}
		}
	}

	private boolean isDuplicate(int pickedNumber) {
		return numbers.contains(pickedNumber);
	}
}
