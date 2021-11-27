package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.type.NumberRangeType;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private static List<Integer> computerNumbers;

	public Computer() {
		this.computerNumbers = new ArrayList<>(NumberRangeType.ANSWER_SIZE.getNumberRange());
	}

	public static List<Integer> getComputerNumbers() {
		return computerNumbers;
	}

	public void generateAnswerNumbers() {
		int pickCount = 0;
		while (pickCount < NumberRangeType.ANSWER_SIZE.getNumberRange()) {
			int pickedNumber = Randoms.pickNumberInRange(NumberRangeType.MIN_NUMBER.getNumberRange(),
				NumberRangeType.MAX_NUMBER.getNumberRange());
			if (!isDuplicate(pickedNumber)) {
				computerNumbers.add(pickedNumber);
				pickCount++;
			}
		}
	}

	private boolean isDuplicate(int pickedNumber) {
		return computerNumbers.contains(pickedNumber);
	}
}
